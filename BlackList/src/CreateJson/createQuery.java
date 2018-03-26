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
		//first of all search in databaseai-qaida  
        conn= DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/databaseaiqaida?autoReconnect=true&useSSL=false&serverTimezone=UTC",
            "root",
            "abcd1234");
		List <Person> person1 = new ArrayList<Person>();
		List <Person> person2 = new ArrayList<Person>();
		Statement stmt = null;
		stmt = conn.createStatement();
		for (Person person : persons){
		if (person.getPar2() != null) {
			String sql = "SELECT * FROM ((databaseaiqaida.person "
					+ "INNER JOIN databaseaiqaida.location ON databaseaiqaida.person.idperson = databaseaiqaida.location.idlocation)"
					+ "INNER JOIN databaseaiqaida.info ON databaseaiqaida.person.idperson = databaseaiqaida.info.idinfo)"
					+ "WHERE FIRST_NAME Like '%" + person.getPar1() +
					"%'AND LAST_NAME LIKE '%" + person.getPar2() +"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String firstname = rs.getString("FIRST_NAME");
				String lastname = rs.getString("LAST_NAME");
				String thirdname = rs.getString("THIRD_NAME");
				String fourthname = rs.getString("FOURTH_NAME");
				String country = rs.getString("COUNTRY");
				String note = rs.getString("NOTE");
				String reference = rs.getString("REFERENCE_NUMBER");
				String listed = rs.getString("LISTED_ON");
				String comments = rs.getString("COMMENTS1");
				if (firstname != null && lastname != null)
				person1.add(new Person(firstname, lastname, thirdname, country,  note, reference, fourthname, note , listed, comments));
			}
			if (person1 != null){
				for (Person personas : person1){
					if (personas.getPar6() == person.getPar6() || personas.getPar4() == person.getPar4() || personas.getPar5() == person.getPar5() || personas.getPar7() == person.getPar7())
						person2.add(person);
				}
			}
		}
		}
		conn.close();
		//first of all search in databasesdn  
		conn= DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/SDN?autoReconnect=true&useSSL=false&serverTimezone=UTC",
	            "root",
	            "abcd1234");
		stmt = conn.createStatement();
		for (Person person : persons){
		if (person.getPar2() != null) {
			String sql = "SELECT * FROM ((SDN.person "
					+ "INNER JOIN SDN.location ON SDN.person.idperson = SDN.location.idlocation)"
					+ "INNER JOIN SDN.info ON SDN.person.idperson = SDN.info.idinfo)"
					+ "WHERE firstname Like '%" + person.getPar1() +
					"%'AND lastname LIKE '%" + person.getPar2() +"%'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String city = rs.getString("city");
				String category = rs.getString("category");
				String sdnType = rs.getString("sdnType");
				String country = rs.getString("country");
				String remarks = rs.getString("remarks");
				String program = rs.getString("program");
				String dateOfBirth = rs.getString("dateOfBirth");
				if (firstname != null && lastname != null)
				person1.add(new Person(firstname, lastname, category, country, city, sdnType , remarks , program, dateOfBirth));
			}
			if (person1 != null){
				for (Person personas : person1){
					if (personas.getPar6() == person.getPar6() || personas.getPar4() == person.getPar4() || personas.getPar5() == person.getPar5() || personas.getPar7() == person.getPar7())
						person2.add(person);
				}
			}
		}
		}
		conn.close();
		//first of all search in `databaseunsecuritysanctionslist`
		conn= DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/databaseunsecuritysanctionslist?autoReconnect=true&useSSL=false&serverTimezone=UTC",
	            "root",
	            "abcd1234");
		stmt = conn.createStatement();
		for (Person person : persons){
		if (person.getPar2() != null) {
			String sql = "SELECT * FROM ((databaseunsecuritysanctionslist.person "
					+ "INNER JOIN databaseunsecuritysanctionslist.location ON databaseunsecuritysanctionslist.person.idperson = databaseunsecuritysanctionslist.location.idlocation)"
					+ "INNER JOIN databaseunsecuritysanctionslist.info ON databaseunsecuritysanctionslist.person.idperson = databaseunsecuritysanctionslist.info.idinfo)"
					+ "WHERE FIRSTNAME Like '%" + person.getPar1() +
					"%'AND LASTNAME LIKE '%" + person.getPar2() +"%'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String middleName = rs.getString("MIDDLENAME");
				String wholeName = rs.getString("WHOLENAME");
				String place = rs.getString("PLACE");
				String country = rs.getString("COUNTRY");
				String function = rs.getString("FUNCTION");
				String gender = rs.getString("GENDER");
				String language = rs.getString("LANGUAGE");
				String date = rs.getString("DATE");
				
				if (firstname != null && lastname != null)
				person1.add(new Person(firstname, lastname, middleName, country, place, wholeName, function , gender, language, date));
			}
			if (person1 != null){
				for (Person personas : person1){
					if (personas.getPar6() == person.getPar6() || personas.getPar4() == person.getPar4() || personas.getPar5() == person.getPar5() || personas.getPar7() == person.getPar7() )
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


