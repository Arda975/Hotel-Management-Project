
public class Reservation {
	String as_customer_id;
	String	room_id;
	String	date_of_arrival;
	String date_of_departure;
	public Reservation(String as_customer_id, String room_id, String date_of_arrival, String date_of_departure) {
		
		this.as_customer_id = as_customer_id;
		this.room_id = room_id;
		this.date_of_arrival = date_of_arrival;
		this.date_of_departure = date_of_departure;
	}
	public String getAs_customer_id() {
		return as_customer_id;
	}
	public void setAs_customer_id(String as_customer_id) {
		this.as_customer_id = as_customer_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getDate_of_arrival() {
		return date_of_arrival;
	}
	public void setDate_of_arrival(String date_of_arrival) {
		this.date_of_arrival = date_of_arrival;
	}
	public String getDate_of_departure() {
		return date_of_departure;
	}
	public void setDate_of_departure(String date_of_departure) {
		this.date_of_departure = date_of_departure;
	}
	
	
}
