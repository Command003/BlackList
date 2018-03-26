package DataBase;

import XmlParse.*;
import org.w3c.dom.Document;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    public static Connection connection;



    public  void TableModel() {
    	
        ResurseXml resurseXml = new ResurseXml();
        List<String> person = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/SDN?autoReconnect=true&useSSL=false&serverTimezone=UTC",
                    "root",
                    "abcd1234");
            connection.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }

        for(int i = 0; i < resurseXml.mapvalue.size(); i++) {
            String [] arr = resurseXml.mapvalue.get(i).toString().split(", ");

            try {
                Statement statement = connection.createStatement();

                statement.executeUpdate(

                        "INSERT INTO SDN.person " +
                                "(firstname, lastname) " +
                                "VALUES ('"
                                + arr[0] + "', '"
                                + arr[1] + "'); "
                );

                statement.executeUpdate(

                        "INSERT INTO SDN.location " +
                                "(city, country, adress1) " +
                                "VALUES ('"
                                + arr[4] + "', '"
                                + arr[3] + "', '"
                                + arr[6] + "'); "
                );

                statement.executeUpdate(

                        "INSERT INTO SDN.info " +
                                "(category, sdnType, remarks, program, dateOfBirth) " +
                                "VALUES ('"
                                + arr[2] + "', '"
                                + arr[5] + "', '"
                                + arr[7] + "', '"
                                + arr[8] + "', '"
                                + arr[9] + "'); "
                );



            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnecion () {

        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
