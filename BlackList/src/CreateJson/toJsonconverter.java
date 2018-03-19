
package CreateJson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class toJsonconverter {
	public static void main (String [] args){
		//JSON file for all
		List <Person> personList = new ArrayList<Person>();
		File json = new File("src/test.json");
		for (Person person : personList){
		JSONObject obj = new JSONObject(); //creating of  JSON object
		obj.put("firstname", person.getFirstName()); 
		obj.put("lastname", person.getLastName());
		obj.put("country", person.getCountry());
		obj.put("dateofbirth", person.getDateOfBirth());
		obj.put("gender", person.getGender());
		
		try {
			@SuppressWarnings("resource")
			FileWriter writer = new FileWriter(json); //creating json file 
			writer.write(obj.toString()  + System.lineSeparator()); //writing to the json object
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}
	

}
