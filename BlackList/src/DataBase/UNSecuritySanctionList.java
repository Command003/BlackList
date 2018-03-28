package DataBase;

import XmlParse.*;
import java.sql.*;
import org.apache.log4j.Logger;

public class UNSecuritySanctionList {

	public static Connection connection;
	private static Logger logger = Logger.getLogger(UNSecuritySanctionList.class.getName());

	public  void tableModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/databaseunsecuritysanctionslist?autoReconnect=true&useSSL=false&serverTimezone=UTC",
					"root",
					"abcd1234");
			connection.setAutoCommit(true);

		} catch (Exception e) {
			logger.error(e);
		}
		try {
			Statement statement = connection.createStatement();

			statement.executeUpdate(
					"DELETE FROM databaseunsecuritysanctionslist.person;"
					);

			statement.executeUpdate(
					"ALTER TABLE databaseunsecuritysanctionslist.person AUTO_INCREMENT = 1;"
					);

			statement.executeUpdate(
					"DELETE FROM databaseunsecuritysanctionslist.location;"
					);

			statement.executeUpdate(
					"ALTER TABLE databaseunsecuritysanctionslist.location AUTO_INCREMENT = 1;"
					);

			statement.executeUpdate(
					"DELETE FROM databaseunsecuritysanctionslist.info;"
					);

			statement.executeUpdate(
					"ALTER TABLE databaseunsecuritysanctionslist.info AUTO_INCREMENT = 1;"
					);

		} catch (SQLException e) {
			logger.error(e);
		}
		for(int i = 0; i < ResurseXml.mapvalue.size(); i++) {
			String [] arr = ResurseXml.mapvalue.get(i).toString().split(", ");
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"INSERT INTO databaseunsecuritysanctionslist.person " +
								"(FIRSTNAME, LASTNAME, MIDDLENAME, WHOLENAME) " +
								"VALUES ('"
								+ arr[0].replace("'","").replace(",","") + "', '"
								+ arr[1].replace("'","").replace(",","") + "', '"
								+ arr[2].replace("'","").replace(",","") + "', '"
								+ arr[3].replace("'","").replace(",","") + "'); "
						);
				statement.executeUpdate(
						"INSERT INTO databaseunsecuritysanctionslist.location " +
								"(COUNTRY, PLACE) " +
								"VALUES ('"
								+ arr[7].replace("'","").replace(",","") + "', '"
								+ arr[4].replace("'","").replace(",","") + "'); "
						);
				statement.executeUpdate(
						"INSERT INTO databaseunsecuritysanctionslist.info " +
								"(FUNCTION, GENDER, DATE, LANGUAGE) " +
								"VALUES ('"
								+ arr[5].replace("'","").replace(",","") + "', '"
								+ arr[9].replace("'","").replace(",","") + "', '"
								+ arr[8].replace("'","").replace(",","") + "', '"
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


