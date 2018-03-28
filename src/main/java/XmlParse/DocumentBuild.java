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


public class DocumentBuild {  private Document doc;
// Building an object model of the source XML file
String as = ResurseXml.ph;

public  Document createDocument() {


    try
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse(as);

        // It is not necessary to perform normalization, but it is recommended
         doc.getDocumentElement().normalize();

    } catch (ParserConfigurationException e){System.out.println("Cannot parse file."); System.exit(1);}
    catch(SAXException e){System.out.println("Cannot parse file."); System.exit(1);}
    catch(java.io.IOException ex){System.out.println("Cannot read input file."); System.exit(1);
    }finally {return  doc;}

}

}
