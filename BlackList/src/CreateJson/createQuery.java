package CreateJson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class createQuery {
	protected Connection conn;

	public List <Person> searchPerson (List <Person> persons) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
        conn= DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/blacklistdb?autoReconnect=true&useSSL=false",
            "root",
            "abcd1234");
		List <Person> person1 = new ArrayList<Person>();
		List <Person> person2 = new ArrayList<Person>();
		Statement stmt = null;
		stmt = conn.createStatement();
		for (Person person : persons){
		if (person.getFirstname() != null && person.getLastname() != null || person.getWholename() != null) {
			String sql = "SELECT * FROM ((blacklistdb.persons "
					+ "INNER JOIN blacklistdb.passport ON blacklistdb.persons.idpassport = blacklistdb.passport.idpassport)"
					+ "INNER JOIN blacklistdb.address ON blacklistdb.persons.idaddress = blacklistdb.address.idaddress)"
					+ "WHERE firstname Like '%" + person.getFirstname() +
					"%'AND lastname LIKE '%" + person.getLastname() + 
					"%'OR wholename LIKE '" + person.getWholename() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String wholename = rs.getString("wholename");
				String country1 = rs.getString("country");
				String index = rs.getString("index");
				String gender1 = rs.getString("gender");
				String city = rs.getString("city");
				String number = rs.getString("number");
				String street = rs.getString("street");
				person1.add(new Person(firstname, lastname, wholename, number, gender1, country1, city , street, index));
			}
			if (person1 != null){
				for (Person personas : person1){
					if (personas.getNumber() == person.getNumber() || personas.getCountry() == person.getCountry() || personas.getGender() == person.getGender() )
						person2.add(person);
				}
			}
		}
		}
		if (person2.size() >= 1)
			return person2;
		else
			return person1;	
	}
}


