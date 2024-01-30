

public class Customer {
	String name;
	String surname;
	String gender;
	String birthdate;
	String addresstext;
	String district;
	String city;
	String phone;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddresstext() {
		return addresstext;
	}

	public void setAddresstext(String addresstext) {
		this.addresstext = addresstext;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Customer(String name, String surname, String gender, String birthdate, String addresstext, String district,
			String city, String phone) {
		
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthdate = birthdate;
		this.addresstext = addresstext;
		this.district = district;
		this.city = city;
		this.phone = phone;
	}
	
}