package CreateJson;

public class Person {
	

	public Person(String firstname, String lastname, String wholename, String number, String gender, String country,
			String city, String street, String index) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.wholename = wholename;
		this.number = number;
		this.gender = gender;
		this.country = country;
		this.city = city;
		this.street = street;
		this.index = index;
	}
	private String firstname;
	private String lastname;
	private String wholename;
	private String number;
	private String gender;
	private String country;
	private String city;
	private String street;
	private String index;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getWholename() {
		return wholename;
	}
	public void setWholename(String wholename) {
		this.wholename = wholename;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	


}
