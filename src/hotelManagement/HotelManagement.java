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

		// Hotel(String name,Integer regularWeekDay,Integer regularWeekEnd,Integer
		// rewardeeWeekDay,Integer rewardeeWeekEnd)

		HotelFactory hotelFactory = new HotelFactory();
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

		for (String result : results) {
			if (result.contains("sun") || result.contains("sat")) {

				Customer cust = new Customer.Builder().setType(customerType).setDay("Weekend").build();
				hotelFactory.findtheCheapestHotel(hotelList, cust);
			} else {
				Customer cust = new Customer.Builder().setType(customerType).setDay("Weekday").build();
				hotelFactory.findtheCheapestHotel(hotelList, cust);
			}
		}
	}
}

// INPUT : regular, 16Mar2010(sun), 19Mar2010(wed), 21Mar2010(Fri) , 21Mar2010(sat)

/*
 * String remaining = s.replace(customerType, " ");
 * 
 * System.out.println(remaining);
 */
// String[] commaSeparatedArr = remaining.split("\\s*,\\s*");

// List<String> result = Arrays.stream(commaSeparatedArr).collect(Collectors.toList());
