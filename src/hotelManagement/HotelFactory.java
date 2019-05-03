package hotelManagement;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class HotelFactory {
	
	public static List<String> findtheCheapestHotel(String customerType, List<Hotel> hotelList, List<String> results) {
		
		for (String result : results) {

			if (result.contains("SUN") || result.contains("sat")) {
				if (customerType.equalsIgnoreCase("regular")) {

					for (Hotel hotel : hotelList){
						findtheCheapestHotel(hotel.getRegularWeekEnd());
					}
					
				} else {
					findtheCheapestHotel(hotelList);
				}
			} else {
				if (customerType.equalsIgnoreCase("regular")) {

					findtheCheapestHotel(hotelList);
				} else {
					findtheCheapestHotel(hotelList);
				}

			}

		
		List<String> cheapestHotel;
		return cheapestHotel;
		
		
	}
	
}
