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




public class GetTitleTabl {


	  public void methodGetTileTabl(Document doc) {
		  
	    	Element root =doc.getDocumentElement();
	      
	       Node ch =getNoTextElement(root);
	       	    
	    for(Node ch2 = ch.getFirstChild(); ch2!=null; ch2=ch2.getNextSibling())	{
	      if (ch2.getNodeName()!="#text")
	      {      
	      ResursXml.listTablePerson.add(ch2.getNodeName());}		    		
	    }       	
	    }	
	    	
	    
	  
	  
	  
	    
	        private  Node getNoTextElement(Element  elt){
	        	
	        	 for (Node ch = elt.getFirstChild(); ch !=null; ch = ch.getNextSibling()){
	        	   	if (ch.getNodeName()!="#text") {
	        	   		
	        		   		return ch;
	        		   	}        	
	        }
	            return null;
	        }
	    	
} 
	    