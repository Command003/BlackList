package XmlParse;

import java.util.*;
public class ResurseXml {

    public static List<String> list = new ArrayList<>();

    public static Map<Integer, List<String>> mapvalue = new HashMap<Integer,List<String>>();
    public static String ph = "src/XmlParse/ResursXml2.xml";

    public static void initList() {

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
    }
}
