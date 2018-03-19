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
	List <Person> person = new ArrayList<Person>();
	
	//
	public List <Person> searchPerson (String firstName, String lastName, String country, String dateOfBirth, String gender) throws SQLException{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/?autoReconnect=true&useSSL=false";
			String user = "root";
			String pass = "abcd1234";
			conn = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Statement stmt = null;
		stmt = conn.createStatement();
		//if all fields are entered in a GUI/FX we first of all search for a person using all fields data
		if (firstName != null && lastName != null && country != null && dateOfBirth !=null) {
			String sql = "SELECT * FROM 'table' WHERE firstname Like '%" + firstName +
					"%'AND lastname LIKE '" + lastName + "'AND country LIKE '" + country +
					"'AND dateofbirth LIKE '" + dateOfBirth +"'AND gender LIKE '" + gender + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String country1 = rs.getString("country");
				String datebirth = rs.getString("dateofbirth");
				String gender1 = rs.getString("gender");
				int id = rs.getInt("idperson");
				// if there is match with all field data then create new object person with found data and add it to a List.
				if (firstname != null && lastname != null && country1 != null && datebirth != null) {
					person.add(new Person(id, firstname, lastname, country1, datebirth, gender1));
				}
			}
			//if there was no matches using all fields, there will be an empty list. so we start searching only using firstname and name values
			if (person == null) {
				stmt = conn.createStatement();
				if (firstName != null && lastName != null) {
					sql = "SELECT * FROM 'table' WHERE firstname Like '%" + firstName +
							"%'AND lastname LIKE '" + lastName +"'AND gender LIKE '" + gender + "'";
					rs = stmt.executeQuery(sql);
					while(rs.next()){
						String firstname = rs.getString("firstname");
						String lastname = rs.getString("lastname");
						String country1 = rs.getString("country");
						String datebirth = rs.getString("dateofbirth");
						String gender1 = rs.getString("gender");
						int id = rs.getInt("idperson");
						// if there is match with all field data then create new object person with found data and add it to a List.
						if (firstname != null && lastname != null) {
							person.add(new Person(id, firstname, lastname, country1, datebirth, gender1));
						}
					}
				} 
			} 
			//if was entered only surname and name, so  we search for a person using only two fields
		}else if (firstName != null && lastName != null) {
			String sql = "SELECT * FROM 'table' WHERE firstname Like '%" + firstName +
					"%'AND lastname LIKE '" + lastName +"'AND gender LIKE '" + gender + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String country1 = rs.getString("country");
				String datebirth = rs.getString("dateofbirth");
				String gender1 = rs.getString("gender");
				int id = rs.getInt("idperson");
				// if there is match with all field data then create new object person with found data and add it to a List.
				if (firstname != null && lastname != null) {
					person.add(new Person(id, firstname, lastname, country1, datebirth, gender1));
				}
			}	
		}
		//set result true/false for necessary field e.g. setValue(true/false) and send it to GUI/FX form
		// saving to JSON file method shall be inserted
		return person;	
	}
}


