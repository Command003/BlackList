//
//package CreateJson;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import org.json.JSONObject;
//
//
//public class toJsonconverter {
//		//test for arraylist writing to a json file
//		/*public static void main(String[] args) throws IOException{
//		List <Person>  list = new ArrayList <Person>();
//		list.add(new Person("artjoms", "skripko", "artjoms skripko", "11111", "m", "latvia",
//			"riga"));
//		list.add(new Person("artjoms1", "skripko1", "artjoms skripko1", "11111", "m", "latvia",
//				"riga"));
//		list.add(new Person("artjoms2", "skripko2", "artjoms skripko", "11111", "m", "latvia",
//				"riga"));
//		list.add(new Person("artjoms3", "skripko3", "artjoms skripko", "11111", "m", "latvia",
//				"riga"));
//		convertToJson(list);
//		}
//		*/
//	public static void convertToJson(List <Person> personList) throws IOException{
//		File json = new File("src/test.json");
//		@SuppressWarnings("resource")
//		FileWriter writer = new FileWriter(json);
//		for (Person person : personList){
//		JSONObject obj = new JSONObject(); //creating of  JSON object
//		obj.put("firstname", person.getFirstname()); 
//		obj.put("lastname", person.getLastname());
//		obj.put("wholename", person.getWholename());
//		obj.put("number", person.getNumber());
//		obj.put("country", person.getCountry());
//		obj.put("city", person.getCity());
//		obj.put("street", person.getStreet());
//		obj.put("index", person.getIndex());
//		obj.put("gender", person.getGender());
//		writer.write(obj.toString()  + System.lineSeparator()); //writing to the json object
//		}
//		writer.flush();
//	}
//
//}
