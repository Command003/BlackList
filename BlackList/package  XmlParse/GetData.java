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



public class GetData {


    public  void GetDataMethod (Document doc) {


        System.out.println("Root element: "
                + doc.getDocumentElement().getNodeName());
        System.out.println("============================");

        // Получаем все узлы с именем "person"
        NodeList nodeList = doc.getElementsByTagName("person");

        for (int i = 0; i < nodeList.getLength(); i++) {
            // Выводим информацию по каждому из найденных элементов
            Person person = new Person();

            Node node = nodeList.item(i);
            System.out.println();
            System.out.println("Текущий элемент: " + node.getNodeName());
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;

                System.out.println("Firstname: " + element
                        .getElementsByTagName("Firstname").item(0)
                        .getTextContent());

                person.setFirstname(element
                        .getElementsByTagName("Firstname").item(0)
                        .getTextContent());
                
                
                

                System.out.println("Lastname: " + element
                        .getElementsByTagName("Lastname").item(0)
                        .getTextContent());
                
                person.setLastname(element
                        .getElementsByTagName("Lastname").item(0)
                        .getTextContent());
                
                
                
                

                System.out.println("Wholename: " + element
                        .getElementsByTagName("Wholename").item(0)
                        .getTextContent());

                person.setWholename(element
                        .getElementsByTagName("Wholename").item(0)
                        .getTextContent());
                
                
                


                System.out.println("number " + element
                        .getElementsByTagName("number").item(0)
                        .getTextContent());                
                
                person.setNamber(element
                        .getElementsByTagName("number").item(0)
                        .getTextContent());
                
             

                
                System.out.println("country " + element
                        .getElementsByTagName("country").item(0)
                        .getTextContent());                
                
                person.setCountry(element
                        .getElementsByTagName("country").item(0)
                        .getTextContent());   
                                    
                
                
                

                System.out.println("gender " + element
                        .getElementsByTagName("gender").item(0)
                        .getTextContent());                
                
              person.setGender(element
                      .getElementsByTagName("gender").item(0)
                      .getTextContent());
                
                

                

                System.out.println("city " + element
                        .getElementsByTagName("city").item(0)
                        .getTextContent());
                
                person.setCity(element
                        .getElementsByTagName("city").item(0)
                        .getTextContent());
                
                
                
                

                System.out.println("street " + element
                        .getElementsByTagName("street").item(0)
                        .getTextContent());
                
                person.setStreet(element
                        .getElementsByTagName("street").item(0)
                        .getTextContent());
                
                
                
                
                

                System.out.println("index " + element
                        .getElementsByTagName("index").item(0)
                        .getTextContent());
                
                
                person.setIndex(element
                        .getElementsByTagName("index").item(0)
                        .getTextContent());
                
                
               
                
                
                

                ResursXml.listPerson.add(person);


            }

        }
    }}