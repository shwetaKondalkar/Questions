package restWebservice;

package com.meganexus.sequation.mojpef.contract.api.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meganexus.sequation.audit.producer.payload.Operations;
import com.meganexus.sequation.mojpef.contract.api.database.service.AbstractMojPefCRUDService;
import com.meganexus.sequation.mojpef.contract.api.dto.AuthTokenDTO;
import com.meganexus.sequation.mojpef.contract.api.dto.FeatureDetails;
import com.meganexus.sequation.mojpef.contract.api.exception.DuplicateCheckerException;
import com.meganexus.sequation.mojpef.contract.api.exception.EndDateBeforeStartDateException;
import com.meganexus.sequation.mojpef.contract.api.exception.MinimumCourseNameLengthException;
import com.meganexus.sequation.mojpef.contract.api.exception.NullEntityException;
import com.meganexus.sequation.mojpef.contract.api.exception.RestTemplateException;
import com.meganexus.sequation.mojpef.contract.api.exception.UnAuthorizeUserException;
import com.meganexus.sequation.mojpef.contract.api.exception.UnEditableFieldException;
import com.meganexus.sequation.mojpef.contract.api.timetable.dto.CourseDTO;
import com.meganexus.sequation.mojpef.contract.api.timetable.dto.CreateCourseDTO;
import com.meganexus.sequation.mojpef.contract.api.timetable.dto.CurriculumDTO;
import com.meganexus.sequation.mojpef.contract.api.timetable.dto.SearchDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class MojPefContractController extends AbstractMojPefCRUDService{
	private static final Logger LOGGER = LogManager.getLogger(MojPefContractController.class);

	@PostMapping("/search")
	public Page<CourseDTO> findAllPaginated(@RequestBody SearchDTO searchDTO, Pageable pageable, ServletRequest request,
			ServletResponse response) throws UnAuthorizeUserException, IOException, NoSuchAlgorithmException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(AUTHORIZATION);
		AuthTokenDTO authTokenDTO = authTokenService.createAuthTokenDTO(authToken);
		JSONObject flag = authorizeService.isAuthorize(authToken, READ);
		searchDTO.setOrgId(authTokenDTO.getOrgId());
		if (flag.get(ISAUTHORIZED).equals(Boolean.TRUE)) {
			Page<CourseDTO> page = courseService.findAllPaginated(searchDTO, pageable);
			String auditDetails;
			if (searchDTO.getKeyword() == null) {
				auditDetails = "Searched with no keyword and fetched records count : ";
			} else {
				auditDetails = "Searched with " + searchDTO.getKeyword() + " keyword and fetched records count : ";
			}

			this.auditService.triggerAuditEvent(new FeatureDetails(SecureRandom.getInstance(SHA1PRNG).nextLong(),
					"Searched For Courses", auditDetails + page.getSize()), Operations.SEARCH,MOJ_COURSE);
			
			LOGGER.info("Search Course Details");
			return page;
		}
		throw new UnAuthorizeUserException();
	}

	@RequestMapping(value = "/createCourse", method = RequestMethod.POST)
	public ResponseEntity<CreateCourseDTO> createCourse(@Valid @RequestBody CreateCourseDTO createCourseDTO,
			HttpServletRequest request, ServletResponse response)
			throws IOException, UnAuthorizeUserException, NullEntityException, ParseException, RestTemplateException,
			MinimumCourseNameLengthException, DuplicateCheckerException, EndDateBeforeStartDateException {

		HttpServletRequest httpRequest = request;
		String authToken = httpRequest.getHeader(AUTHORIZATION);
		JSONObject flag = authorizeService.isAuthorize(authToken, CREATE);
		if (flag.get(ISAUTHORIZED).equals(Boolean.TRUE)) {
			if (createCourseDTO.getCourseName() == null) {
				throw new NullEntityException();
			}
			createCourseDTO = createCourseService.createCourse(createCourseDTO, authToken);
			auditService.triggerAuditEvent(new FeatureDetails(createCourseDTO.getId(), createCourseDTO.getCourseName(),
					"Course Created " + createCourseDTO.getCourseName()), Operations.CREATE,MOJ_COURSE);
		} else {
			throw new UnAuthorizeUserException();
		}
		LOGGER.info("Create Course Details");
		return new ResponseEntity<>(createCourseDTO, HttpStatus.CREATED);
	}

	@GetMapping("/getCourseById/{courseId}")
	public ResponseEntity<CreateCourseDTO> getCourseById(@PathVariable("courseId") Long courseId,
			ServletRequest request, ServletResponse response)
			throws NullEntityException, UnAuthorizeUserException, IOException {
		if (courseId == null) {
			throw new NullEntityException();
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(AUTHORIZATION);
		 AuthTokenDTO authTokenDTO = authTokenService.createAuthTokenDTO(authToken);
		JSONObject flag = authorizeService.isAuthorize(authToken, READ);
		
		if (flag.get(ISAUTHORIZED).equals(Boolean.TRUE)) {
			CreateCourseDTO course = courseService.getCourseById(courseId,authTokenDTO.getOrgId());
			LOGGER.info("Get Course Details");
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
		throw new UnAuthorizeUserException();
	}

	@PatchMapping("/updateCourseDetails")
	public ResponseEntity<CreateCourseDTO> updateCourse(@RequestBody CreateCourseDTO createCourseDTO,
			HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException,
			UnAuthorizeUserException, NullEntityException, UnEditableFieldException, EndDateBeforeStartDateException {

 		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(AUTHORIZATION);
		JSONObject flag = authorizeService.isAuthorize(authToken, UPDATE);
		if (flag.get(ISAUTHORIZED).equals(Boolean.TRUE)) {
			CreateCourseDTO updateCourseDTO = updateCourseService.updateCourseDetails(createCourseDTO, authToken);
			auditService.triggerAuditEvent(new FeatureDetails(updateCourseDTO.getId(), updateCourseDTO.getCourseName(),
					"Course updated " + updateCourseDTO.getCourseName()), Operations.UPDATE,MOJ_COURSE);
			LOGGER.info("Update Course Details");
			return new ResponseEntity<>(updateCourseDTO, HttpStatus.OK);
		}
		throw new UnAuthorizeUserException();
	}

	@GetMapping("/getCurriculumByEstablishmentId")
	public List<CurriculumDTO> getCurriculumByEstablishmentId(ServletRequest request,
			ServletResponse response) throws NullEntityException, UnAuthorizeUserException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(AUTHORIZATION);
		AuthTokenDTO authTokenDTO = authTokenService.createAuthTokenDTO(authToken);
		List<CurriculumDTO> curriculumList = curriculumService.getCurriculumByEstablishmentId(authTokenDTO.getOrgId());
		LOGGER.info("Get Curriculum By EstablishmentId");
		return curriculumList;
	}

	@DeleteMapping("/archivedCourseById/{courseId}")
	public ResponseEntity<CreateCourseDTO> archivedCourseById(@PathVariable("courseId") Long courseId,
			ServletRequest request, ServletResponse response)
			throws NullEntityException, UnAuthorizeUserException, IOException {
		if (courseId == null) {
			throw new NullEntityException();
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader(AUTHORIZATION);
		JSONObject flag = authorizeService.isAuthorize(authToken, ARCHIEVED);
		if (flag.get(ISAUTHORIZED).equals(Boolean.TRUE) ) {
			CreateCourseDTO course = courseService.archivedCourseById(courseId);
			auditService.triggerAuditEvent(new FeatureDetails(course.getId(), course.getCourseName(),
					"Course Archived " + course.getCourseName()), Operations.DELETE,MOJ_COURSE);
			LOGGER.info("Archived Course Details");
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
		throw new UnAuthorizeUserException();
	}

}
