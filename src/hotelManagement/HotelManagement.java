package hotelManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelManagement {
	
	
	public static void main(String[] args) throws IOException, ParseException {


		Hotel lakeWood = new Hotel("LakeWood", 100, 120, 90, 60);
		Hotel bridgeWood = new Hotel("RidgeWood", 130, 150, 100, 95);
		Hotel ridgeWood = new Hotel("BridgeWood", 195, 150, 120, 90);

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();

		String customerType = input.substring(0, input.indexOf(","));
		System.out.println(customerType);
		List<String> results = new ArrayList<>();

		Pattern pattern = Pattern.compile("\\(([^)]+)\\)");

		Matcher m = pattern.matcher(input);
		while (m.find()) {
			results.add(m.group(1));
		}
		
		
		List<Hotel> hotelList = new ArrayList<>();
		hotelList.add(lakeWood);
		hotelList.add(bridgeWood);
		hotelList.add(ridgeWood);
		
		List<String> cheapestHotelName = HotelFactory.findtheCheapestHotel(customerType,hotelList,results);
		
		for (String result : results) {

			if (result.contains(Weekday.SUN) || result.contains("sat")) {
				if (customerType.equalsIgnoreCase("regular")) {

					findtheCheapestHotel(lakeWood.getRegularWeekEnd(), bridgeWood.getRegularWeekEnd(),
							ridgeWood.getRegularWeekEnd());
				} else {
					findtheCheapestHotel(lakeWood.getRewardeeWeekEnd(), bridgeWood.getRewardeeWeekEnd(),
							ridgeWood.getRewardeeWeekEnd());
				}
			} else {
				if (customerType.equalsIgnoreCase("regular")) {

					findtheCheapestHotel(lakeWood.getRegularWeekDay(), bridgeWood.getRegularWeekDay(),
							ridgeWood.getRegularWeekDay());
				} else {
					findtheCheapestHotel(lakeWood.getRewardeeWeekDay(), bridgeWood.getRewardeeWeekDay(),
							ridgeWood.getRewardeeWeekDay());
				}

			}

		}



	}

	/*private static void findtheCheapestHotel(Integer regularWeekEnd, Integer regularWeekEnd2, Integer regularWeekEnd3) {

	}
*/
}



/*
 * String remaining = s.replace(customerType, " ");
 * 
 * System.out.println(remaining);
 */
// String[] commaSeparatedArr = remaining.split("\\s*,\\s*");

// List<String> result = Arrays.stream(commaSeparatedArr).collect(Collectors.toList());
