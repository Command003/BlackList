package XmlParse;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuild {  
    // Строим объектную модель исходного XML файла
    

    public  Document createDocument(String ph) {
    	Document doc = null;
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ph);
            Element table = doc.getDocumentElement();
            Node row3 = table.getElementsByTagName("publshInformation").item(0);
            table.removeChild(row3);
            Node aka = table.getElementsByTagName("aka").item(0);
            table.removeChild(aka);  
        } catch (ParserConfigurationException e){
            System.out.println("Cannot parse file.");
            System.exit(1);

        } catch(SAXException e){
            System.out.println("Cannot parse file.");
            System.exit(1);

        } catch(java.io.IOException ex){
            System.out.println("Cannot read input file.");
            System.exit(1);

        } finally {
            return doc;
        }
    }
}
