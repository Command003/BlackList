package testetestet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class A {
	public static Connection connection;
	public static String colname = "";
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/blacklistdb?autoReconnect=true&useSSL=false",
				"root",
				"abcd1234");
		connection.setAutoCommit(true);
//		B.aaa();
//	
		Statement statement = connection.createStatement();
//		String sql = "CREATE TABLE table2 (age VARCHAR(45), name VARCHAR(45));";
//		statement.executeUpdate(sql);
		String a = "7";
		int b = 1;
		 statement.executeUpdate(

                 "INSERT INTO blacklistdb.table2 " +
                     "(age, name) " +
                     "VALUES ('"
                     + a + "', '"
                     + b + "'); "
             );
		 
			
//		for (String str : B.test){
//		 colname = colname + str + " varchar(45),";
//		}
//		colname = colname.substring(0, colname.length() - 1);
//		String sql = "CREATE TABLE a (" + colname + ");";

		
			    
			//CREATE TABLE a (1 VARCHAR(45) , CREATE TABLE a (2 VARCHAR(45) ,CREATE TABLE a (3 VARCHAR(45)
	}
}
