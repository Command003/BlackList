package DataBase;

import XmlParse.*;
import org.apache.log4j.Logger;
import java.sql.*;

public class AIQaida {
	public static Connection connection;
	private static Logger logger = Logger.getLogger(AIQaida.class.getName());
	public  void TableModel() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/databaseaiqaida?autoReconnect=true&useSSL=false&serverTimezone=UTC",
					"root",
					"abcd1234");
			connection.setAutoCommit(true);
		} catch (Exception e) {
			logger.error(e);
		}
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"DELETE FROM databaseaiqaida.person;"
					);
			statement.executeUpdate(
					"ALTER TABLE databaseaiqaida.person AUTO_INCREMENT = 1;"
					);
			statement.executeUpdate(
					"DELETE FROM databaseaiqaida.location;"
					);
			statement.executeUpdate(
					"ALTER TABLE databaseaiqaida.location AUTO_INCREMENT = 1;"
					);
			statement.executeUpdate(
					"DELETE FROM databaseaiqaida.info;"
					);
			statement.executeUpdate(
					"ALTER TABLE databaseaiqaida.info AUTO_INCREMENT = 1;"
					);
		} catch (SQLException e) {
			logger.error(e);
		}
		for(int i = 0; i < ResurseXml.mapvalue.size(); i++) {
			String [] arr = ResurseXml.mapvalue.get(i).toString().split(", ");
			try {
				Statement statement = connection.createStatement();
				statement.executeUpdate(
						"INSERT INTO databaseaiqaida.person " +
								"(FIRST_NAME, LAST_NAME, THIRD_NAME, FOURTH_NAME) " +
								"VALUES ('"
								+ arr[0].replace("'","").replace(",","") + "', '"
								+ arr[1].replace("'","").replace(",","") + "', '"
								+ arr[2].replace("'","").replace(",","") + "', '"
								+ arr[3].replace("'","").replace(",","") + "'); "
						);
				statement.executeUpdate(
						"INSERT INTO databaseaiqaida.location " +
								"(COUNTRY, NOTE) " +
								"VALUES ('"
								+ arr[7].replace("'","").replace(",","") + "', '"
								+ arr[8].replace("'","").replace(",","") + "'); "
						);
				statement.executeUpdate(
						"INSERT INTO databaseaiqaida.info " +
								"(REFERENCE_NUMBER, LISTED_ON, COMMENTS1) " +
								"VALUES ('"
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

