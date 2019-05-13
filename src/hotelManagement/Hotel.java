package hotelManagement;

public class Hotel {
	
	private String hotelName;
    private Integer regularWeekDay;
    private Integer regularWeekEnd;
    private Integer rewardeeWeekDay;
    private Integer rewardeeWeekEnd;

    Hotel(String name,Integer regularWeekDay,Integer regularWeekEnd,Integer rewardeeWeekDay,Integer rewardeeWeekEnd) {
        this.hotelName = name;
	this.regularWeekDay = regularWeekDay;
	this.regularWeekEnd = regularWeekEnd;
	this.rewardeeWeekDay = rewardeeWeekDay;
	this.rewardeeWeekEnd = rewardeeWeekEnd;
    }
    public Integer getRegularWeekDay() {
        return regularWeekDay;
    }

    public void setRegularWeekDay(Integer regularWeekDay) {
        this.regularWeekDay = regularWeekDay;
    }

    public Integer getRegularWeekEnd() {
        return regularWeekEnd;
    }

    public void setRegularWeekEnd(Integer regularWeekEnd) {
        this.regularWeekEnd = regularWeekEnd;
    }

    public Integer getRewardeeWeekDay() {
        return rewardeeWeekDay;
    }

    public void setRewardeeWeekDay(Integer rewardeeWeekDay) {
        this.rewardeeWeekDay = rewardeeWeekDay;
    }

    public Integer getRewardeeWeekEnd() {
        return rewardeeWeekEnd;
    }

    public void setRewardeeWeekEnd(Integer rewardeeWeekEnd) {
        this.rewardeeWeekEnd = rewardeeWeekEnd;
    }

    public String getHotelName() {
        return hotelName;
    }
    
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", regularWeekDay=" + regularWeekDay + ", regularWeekEnd="
				+ regularWeekEnd + ", rewardeeWeekDay=" + rewardeeWeekDay + ", rewardeeWeekEnd=" + rewardeeWeekEnd
				+ "]";
	}
	

}
