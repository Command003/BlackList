package BlackList.BlackList;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.apache.log4j.Logger;
import org.junit.Assert; 
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import XmlParse.*;
import XmlParse.DocumentBuild;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class XmlParseUnitTest {	
	/*Document doc;
	
	
	@Before  
	public  void setUpBeforeClass() {		
		String ph ="/home/student/workspace003/BlackList/src/main/java/XmlParse/data.xml";
		try
	    {
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        doc = db.parse(ph);

	    } catch (ParserConfigurationException e){System.out.println("Cannot parse file."); System.exit(1);}
	    catch(SAXException e){System.out.println("Cannot parse file."); System.exit(1);}
	    catch(java.io.IOException ex){System.out.println("Cannot read input file."); System.exit(1);}
			    
	 Assert.assertTrue("No exists  xml file object", doc!=null);
		
	}*/
	
	
	
	
	
	
	   @Test
	      public  void test01parseXML() {
		 
		  	Sborka sb =new Sborka();
		 	String[]s=new String[2];
		    sb.main(s);  
		 	
		   String s1 ="AEROCARIBBEAN AIRLINES";
		  Assert.assertEquals(s1,ResurseXml.mapvalue.get(0).get(1));
	        
		
	   }
	
	
	/*   @Test
	      public void test02getNoTextElement() {

		
	   }
	
	   @Test
	      public void test03toSort() {
	
		
	   }*/
	   
	   
	   
	   
	
}
