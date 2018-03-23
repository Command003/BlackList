package XmlParse;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.List;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

//import java.awt.List;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import java.lang.ArrayIndexOutOfBoundsException;





public class Xmlpars3 {



public static void main(String[] args) {

    // Строим объектную модель исходного XML файла
   


    Document doc;
    DocumentBuild db =new DocumentBuild();
    doc =db.createDocument();

    GetTitleTabl getTitleTabl =new GetTitleTabl();
    getTitleTabl.methodGetTileTabl(doc);

   // GetData getdata =new GetData();
   // getdata.GetDataMethod(doc);

    
    GetDataGeneral t=new GetDataGeneral();
    t.GetDataMethod(doc);
    
    
       
    
for(int i=0; i<ResursXml.map.size(); i++){
	ArrayList<String> list = ResursXml.map.get(i);
	System.out.println();
	
	for (String s: list){
		
		System.out.println(s);
	}
	
}
    
    
    
    
 
 
}}











