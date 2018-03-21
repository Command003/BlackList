
package CreateJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;


public class toJsonconverter {
		//JSON file for all
		public void convertToJson(List <Person> personList) throws IOException{
		File json = new File("src/test.json");
		@SuppressWarnings("resource")
		FileWriter writer = new FileWriter(json);
		for (Person person : personList){
		JSONObject obj = new JSONObject(); //creating of  JSON object
		obj.put("firstname", person.getFirstname()); 
		obj.put("lastname", person.getLastname());
		obj.put("wholename", person.getCountry());
		obj.put("number", person.getNumber());
		obj.put("country", person.getGender());
		obj.put("city", person.getCity());
		obj.put("street", person.getStreet());
		obj.put("index", person.getIndex());
		writer.write(obj.toString()  + System.lineSeparator()); //writing to the json object
		}
		writer.flush();
	}
	

}
