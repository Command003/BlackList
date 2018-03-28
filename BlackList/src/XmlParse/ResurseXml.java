package XmlParse;
import java.util.*;
public class ResurseXml {
	public static List<String> list = new ArrayList<>();
	public static Map<Integer, List<String>> mapvalue = new HashMap<Integer,List<String>>();
	public static void initList(int a) {
		if (a == 0) {
			list.add("firstName");
			list.add("lastName");
			list.add("category");
			list.add("sdnType");
			list.add("remarks");
			list.add("program");
			list.add("dateOfBirth");
			list.add("city");
			list.add("country");
			list.add("adress1");
		} else if(a == 1) {
			list.add("FIRST_NAME");
			list.add("SECOND_NAME");
			list.add("THIRD_NAME");
			list.add("FOURTH_NAME");
			list.add("REFERENCE_NUMBER");
			list.add("LISTED_ON");
			list.add("COMMENTS1");
			list.add("COUNTRY");
			list.add("NOTE");
		} else if (a == 2) {
			list.add("FIRSTNAME");
			list.add("LASTNAME");
			list.add("MIDDLENAME");
			list.add("WHOLENAME");
			list.add("FUNCTION");
			list.add("DATE");
			list.add("LANGUAGE");
			list.add("COUNTRY");
			list.add("PLACE");
		}
	}
}
