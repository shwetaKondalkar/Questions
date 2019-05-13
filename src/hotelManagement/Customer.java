package hotelManagement;

public class Customer {
	private String type;
	private String day;
	private String both;

	public String getType() {
		return type;
	}


	public String getDay() {
		return day;
	}
	
	public String getBoth(){
		return both;
	}


	public Customer(String type, String day) {
		this.type = type;
		this.day = day;
		this.both = type+day;
	}

	public static class Builder {
		private String type;
		private String day;

		public Builder() {}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public Builder setDay(String day) {
			this.day = day;
			return this;
		}



		public Customer build() {
			return new Customer(type, day);
		}
	}
}
