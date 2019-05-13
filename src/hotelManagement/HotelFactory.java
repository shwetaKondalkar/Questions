package hotelManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelFactory implements CheapestHotel {

	private Integer value;

	@Override
	public void findtheCheapestHotel(List<Hotel> hotelList, Customer cust) {

		Map<String, Integer> priceList = new HashMap<>();
		Map<String, Integer> cheapestHotel = new HashMap<>();
		
		for (Hotel hotel : hotelList) {
			
			Operation op = OperatorFactory.getOperation(cust.getBoth());
			op.addToList(hotel, priceList);
		}
		System.out.println(priceList);
		
		priceList.forEach((k,v) -> {
			System.out.println(cheapestHotel.containsKey(k));
			if(!cheapestHotel.containsKey(k)){
				cheapestHotel.put(k, v);
			}else{
				value=cheapestHotel.get(k);
				cheapestHotel.put(k, v+value);
			}
			
		});
		System.out.println(cheapestHotel);
	}
}
			
//			if(cust.getBoth().equalsIgnoreCase("RegularWeekend")){
//				priceList.put(hotel.getHotelName(), hotel.getRegularWeekEnd());
//			}
//				
//			if(cust.getBoth().equalsIgnoreCase("RegularWeekday")){
//				priceList.put(hotel.getHotelName(), hotel.getRegularWeekDay());
//			}
//			if(cust.getBoth().equalsIgnoreCase("RewardeeWeekend")){
//				priceList.put(hotel.getHotelName(), hotel.getRewardeeWeekEnd());
//			}
//			if(cust.getBoth().equalsIgnoreCase("RewardeeWeekday")){
//				priceList.put(hotel.getHotelName(), hotel.getRewardeeWeekDay());
//			}
				
			
			
			/*if (cust.getType().equalsIgnoreCase("Regular") && cust.getDay().equalsIgnoreCase("Weekend")) {

				priceList.put(hotel.getHotelName(), hotel.getRegularWeekEnd());
			}
			if (cust.getType().equalsIgnoreCase("Regular") && cust.getDay().equalsIgnoreCase("Weekday")) {

				priceList.put(hotel.getHotelName(), hotel.getRegularWeekDay());
			}

			if (cust.getType().equalsIgnoreCase("Rewardee") && cust.getDay().equalsIgnoreCase("Weekend")) {

				priceList.put(hotel.getHotelName(), hotel.getRewardeeWeekEnd());
			}
			if (cust.getType().equalsIgnoreCase("Rewardee") && cust.getDay().equalsIgnoreCase("Weekday")) {

				priceList.put(hotel.getHotelName(), hotel.getRewardeeWeekEnd());
			}*/

		
