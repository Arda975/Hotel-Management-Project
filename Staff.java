
public class Staff {
	String name;
	String surname;
    String  birthDate;
     String gender;
     String adresstext;
     String district;
     String city;
     String phoneNumber;
     String job;
     String salary;		

	public Staff(String name, String surname, String birthDate, String gender, String adresstext, String district,
			String city, String phoneNumber, String job, String salary) {
		
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.gender = gender;
		this.adresstext = adresstext;
		this.district = district;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.job = job;
		this.salary = salary;
	}

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdresstext() {
		return adresstext;
	}

	public void setAdresstext(String adresstext) {
		this.adresstext = adresstext;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	   
	    
	    
		
	
	
	
}
