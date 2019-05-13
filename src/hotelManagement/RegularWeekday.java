package hotelManagement;

import java.util.Map;

public class RegularWeekday implements Operation {

	@Override
	public void addToList(Hotel hotel, Map<String, Integer> priceList) {
		priceList.put(hotel.getHotelName(), hotel.getRegularWeekDay());
	}

}
