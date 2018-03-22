package CreateJson;

public class Person {
	public Person(){};
	

	@Override
	public String toString() {
		return "firstname=" + firstname + ", lastname=" + lastname + ", wholename="
				+ wholename  + ", number=" + number + ", gender=" + gender + ", country="
				+ country + ", city=" + city + ", street=" + street + ", index=" + index;
	}

//	public String toString1() {
//		return "firstname=" + firstname + ",n lastname=" + lastname + ",%n wholename="
//				+ wholename  + ", number=" + number + ", gender=" + gender + ", country="
//				+ country + ", city=" + city + ", street=" + street + ", index=" + index;
//	}
	public Person(String firstname, String lastname, String wholename, String number, String gender, String country,
			String city) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.wholename = wholename;
		this.number = number;
		this.gender = gender;
		this.country = country;
		this.city = city;
	}
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
	public Person(
            int idperson,
            int idpassport,
            int idaddress,
            String firstname,
            String lastname,
            String wholename,
            String number,
            String gender,
            String country,
            String city,
            String street,
            String index) {

        super();
        this.idperson = idperson;
        this.idpassport = idpassport;
        this.idaddress = idaddress;
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
	
	private int idperson;
    private String firstname;
    private String lastname;
    private String wholename;

    private int idpassport;
    private String number;
    private String gender;
    private String country;

    private int idaddress;
    private String city;
    private String street;
    private String index;
    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public int getIdpassport() {
        return idpassport;
    }

    public void setIdpassport(int idpassport) {
        this.idpassport = idpassport;
    }

    public int getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(int idaddress) {
        this.idaddress = idaddress;
    }
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
