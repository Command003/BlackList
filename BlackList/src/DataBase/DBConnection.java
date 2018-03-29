package DataBase;

import XmlParse.*;
import org.apache.log4j.Logger;
import java.sql.*;

public class DBConnection {

	public static Connection connection;
	private static Logger logger = Logger.getLogger(DBConnection.class.getName());
	public  void tableModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/SDN?autoReconnect=true&useSSL=false&serverTimezone=UTC",
					"root",
					"abcd1234");
			connection.setAutoCommit(true);

		} catch (Exception e) {
			logger.error(e);
		}
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"DELETE FROM SDN.person;"
					);
			statement.executeUpdate(
					"ALTER TABLE SDN.person AUTO_INCREMENT = 1;"
					);
			statement.executeUpdate(
					"DELETE FROM SDN.location;"
					);
			statement.executeUpdate(
					"ALTER TABLE SDN.location AUTO_INCREMENT = 1;"
					);
			statement.executeUpdate(
					"DELETE FROM SDN.info;"
					);
			statement.executeUpdate(
					"ALTER TABLE SDN.info AUTO_INCREMENT = 1;"
					);
		} catch (SQLException e) {
			logger.error(e);
		}
		for(int i = 0; i < ResurseXml.mapvalue.size(); i++) {
			String [] arr = ResurseXml.mapvalue.get(i).toString().split(", ");
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"INSERT INTO SDN.person " +
								"(firstname, lastname) " +
								"VALUES ('"
								+ arr[0].replace("'","").replace(",","") + "','"
								+ arr[1].replace("'","").replace(",","") + "'); "
						);
				statement.executeUpdate(
						"INSERT INTO SDN.location " +
								"(city, country, adress1) " +
								"VALUES ('"
								+ arr[7].replace("'","").replace(",","") + "', '"
								+ arr[8].replace("'","").replace(",","") + "', '"
								+ arr[9].replace("'","").replace(",","") + "'); "
						);
				statement.executeUpdate(
						"INSERT INTO SDN.info " +
								"(category, sdnType, remarks, program, dateOfBirth) " +
								"VALUES ('"
								+ arr[2].replace("'","").replace(",","") + "', '"
								+ arr[3].replace("'","").replace(",","") + "', '"
								+ arr[4].replace("'","").replace(",","") + "', '"
								+ arr[5].replace("'","").replace(",","") + "', '"
								+ arr[6].replace("'","").replace(",","") + "'); "
						);
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}
	public void closeConnecion () {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			logger.error(e);
		}
	}
}
