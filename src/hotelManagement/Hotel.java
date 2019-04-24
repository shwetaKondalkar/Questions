package hotelManagement;

public class Hotel {
	
	String hotelName;
    private int regularWeekDay;
    private int regularWeekEnd;
    private int rewardeeWeekDay;
    private int rewardeeWeekEnd;

    Hotel(String name,int regularWeekDay,int regularWeekEnd,int rewardeeWeekDay,int rewardeeWeekEnd) {
        this.hotelName = name;
	this.regularWeekDay = regularWeekDay;
	this.regularWeekEnd = regularWeekEnd;
	this.rewardeeWeekDay = rewardeeWeekDay;
	this.rewardeeWeekEnd = rewardeeWeekEnd;
    }
    public int getRegularWeekDay() {
        return regularWeekDay;
    }

    public void setRegularWeekDay(int regularWeekDay) {
        this.regularWeekDay = regularWeekDay;
    }

    public int getRegularWeekEnd() {
        return regularWeekEnd;
    }

    public void setRegularWeekEnd(int regularWeekEnd) {
        this.regularWeekEnd = regularWeekEnd;
    }

    public int getRewardeeWeekDay() {
        return rewardeeWeekDay;
    }

    public void setRewardeeWeekDay(int rewardeeWeekDay) {
        this.rewardeeWeekDay = rewardeeWeekDay;
    }

    public int getRewardeeWeekEnd() {
        return rewardeeWeekEnd;
    }

    public void setRewardeeWeekEnd(int rewardeeWeekEnd) {
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
