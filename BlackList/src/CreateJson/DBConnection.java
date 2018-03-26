//package CreateJson;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//
//
//public class DBConnection {
//
//    public static Connection connection;
//
//    public static void main(String[] args) {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/blacklistdb?autoReconnect=true&useSSL=false",
//                "root",
//                "abcd1234");
//            connection.setAutoCommit(true);
//            //System.out.println(findPerson("Ann", "Smith").size());
//
//            ArrayList<Person> persons;
//            persons = new ArrayList<Person>();
//            persons.add(new Person(
//                "Lana",
//                "Rey",
//                "Lana Del Rey",
//                "US12312",
//                "F",
//                "USA",
//                "New York",
//                "Street",
//                "SF123"));
//
//            TableModel(persons);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        }
////
////        public static List<Person> findPerson (String firstName, String lastName) throws Exception {
////            List<Person> results = new ArrayList<Person>();
////
////            Statement statement = connection.createStatement();
////            ResultSet resultSet = statement.executeQuery(
////                    "SELECT * FROM blacklistdb.persons where firstname LIKE '%" +
////                            firstName + "%' AND lastname LIKE '%" + lastName + "%';");
////            while (resultSet.next())
////                results.add(new Person(
////                        resultSet.getInt("idperson"),
////                        resultSet.getString("firstname"),
////                        resultSet.getString("lastname"),
////                        resultSet.getString("wholename"),
////                        resultSet.getInt("idperson"),
////                        resultSet.getInt("idperson")
////                        ));
////            return results;
////
////        }
//
//    public static void TableModel(ArrayList<Person> persons) {
//        for (Person person : persons){
//            try {
//                Statement statement = connection.createStatement();
//
//                statement.executeUpdate(
//
//                    "INSERT INTO blacklistdb.passport" +
//                        " (number, country, gender) " +
//                        "VALUES ('"
//                        + person.getNumber() + "', '"
//                        + person.getCountry() + "', '"
//                        + person.getGender() + "'); "
//                        
//                );
////
////                statement.executeUpdate(
////
////                        "INSERT INTO blacklistdb.address" +
////                            " (city, street, index) " +
////                            "VALUES ('"
////                            + person.getCity() + "', '"
////                            + person.getStreet() + "', '"
////                            + person.getIndex() + "'); "
////                    );
//
//                statement.executeUpdate(
//
//                    "INSERT INTO blacklistdb.persons " +
//                        "(firstname, lastname, wholename) " +
//                        "VALUES ('"
//                        + person.getFirstname() + "', '"
//                        + person.getLastname() + "', '"
//                        + person.getWholename() + "'); "
//                );
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void closeConnecion () {
//
//        try {
//            connection.close();
//            connection = null;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
