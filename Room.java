
public class Room {
	 String type;
     boolean Aircondition;
     boolean Balcony;
     int price;
 

    public Room(String type, String airco, String balcony, String price) {
        this.type = type;
        this.Aircondition = Boolean.parseBoolean(airco);
        this.Balcony = Boolean.parseBoolean(balcony);
        this.price = Integer.parseInt(price);
      

    }
   
    
    
  
	public void setType(String type) {
		this.type = type;
	}
	public void setAircondition(boolean aircondition) {
		Aircondition = aircondition;
	}
	public void setBalcony(boolean balcony) {
		Balcony = balcony;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
	public String getType() {
        return type;
    }

    public boolean getAircondition() {
        return Aircondition;
    }

    public boolean getBalcony() {
        return Balcony;
    }

    public int getPrice() {
        return price;
    }

    
    
    
    
    
    
    
    
    
    
    public String toString() {
        String airconditionString = Aircondition ? "Aircondition" : "No aircondition";
        String balconyString = Balcony ? "Balcony" : "No balcony";
        return type + ", " + airconditionString + ", " + balconyString + ", " + price;
    }


}
