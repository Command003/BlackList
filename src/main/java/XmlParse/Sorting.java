package XmlParse;




import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

public class Sorting { 
	List<String> toSort() {
    List<String> value = new ArrayList<>();

    for (String s : ResurseXml.list) {
        for (int i = 0; i < DataOfXml.elementname.size(); i++) {
            if (s.equals(DataOfXml.elementname.get(i))) {
                value.add(DataOfXml.elementvalue.get(i));
                break;
            }

            if (!s.equals(DataOfXml.elementname.get(i)) && (i == DataOfXml.elementname.size() - 1)) {
                value.add("null");
            }

        }
    }

    return value;
}
}
	
	
	
	

