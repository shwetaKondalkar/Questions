package hotelManagement;

import java.util.Map;

public class RegularWeekend implements Operation{

	@Override
	public void addToList(Hotel hotel, Map<String, Integer> priceList) {
		 priceList.put(hotel.getHotelName(), hotel.getRegularWeekEnd());
	}

}
