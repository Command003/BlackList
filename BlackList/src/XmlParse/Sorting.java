package XmlParse;

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
				if (!s.equals(DataOfXml.elementname.get(i)) && (i == DataOfXml.elementname.size() - 1))
					value.add(" ");
			}
		} return value;
	}
}





