package hotelManagement;

import java.util.Map;

public class RewardeeWeekend implements Operation {

	@Override
	public void addToList(Hotel hotel, Map<String, Integer> priceList) {
		priceList.put(hotel.getHotelName(), hotel.getRewardeeWeekEnd());
	}

}
