package XmlParse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.*;

public class Sborka {
	
	public static void main(String[] args) {
        ResurseXml.initList();
      DocumentBuild  documentBuild =new DocumentBuild();
       Document doc = documentBuild.createDocument();
       DataOfXml dataOfX =new DataOfXml();
       dataOfX.parseXML(doc);


        for(int i=0; i<ResurseXml.mapvalue.size(); i++){
        List<String> ls = ResurseXml.mapvalue.get(i);
        for(String s: ls){System.out.println(s);}
            System.out.println();
        }
	
	

}
}