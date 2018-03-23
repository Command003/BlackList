package XmlParse;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

//import java.awt.List;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import java.lang.ArrayIndexOutOfBoundsException;





public class GetDataGeneral {
	
public  void GetDataMethod (Document doc) {

		

        System.out.println("Root element: "
                + doc.getDocumentElement().getNodeName());
        System.out.println("============================");

        // Получаем все узлы с именем "person"
        NodeList nodeList = doc.getElementsByTagName("person");

        for (int i = 0; i < nodeList.getLength(); i++) {
            // Выводим информацию по каждому из найденных элементов
          
        	       	
        	ArrayList<String> str = new ArrayList<>();
               	
        	 
            Node node = nodeList.item(i);
            System.out.println();
            System.out.println("Текущий элемент: " + node.getNodeName());
            if (Node.ELEMENT_NODE == node.getNodeType()) {
               
            	Element element = (Element) node;
            	Node ch = getNoTextElement(element);
            	
            	               	     
            	            while(ch!=null)  
            	            	
              { System.out.println(ch.getNodeName()+ " " + element
                        .getElementsByTagName(ch.getNodeName()).item(0)
                        .getTextContent());
                          
               str.add("" + element
                       .getElementsByTagName(ch.getNodeName()).item(0)
                       .getTextContent());
                     
              
	                
                ch=ch.getNextSibling();
                if (ch.getNodeName()=="#text"){
                	ch =ch.getNextSibling();
                	
                }
                                
                }       
            	            
            	            ResursXml.map.put(i, str);   
            	            
            	            
            } 
            
           
            
        }
        
        
	}
        
    
        
        
        private  Node getNoTextElement(Node  elt)
        {
        	
       	 for (Node ch = elt.getFirstChild(); ch !=null; ch = ch.getNextSibling()){
       	   	if (ch.getNodeName()!="#text") {
       	   		 
       		   		return ch;
       		   	}        	
       }
           return null;
       }
        
        


}
