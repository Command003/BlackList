package XmlParse;

import org.w3c.dom.Node;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuild {  
	// Строим объектную модель исходного XML файла
	private static Logger logger = Logger.getLogger(DocumentBuild.class.getName());
	public  Document createDocument(String ph) {
		Document doc = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(ph);
			Element table = doc.getDocumentElement();
			Node row3 = table.getElementsByTagName("publshInformation").item(0);
			table.removeChild(row3);
			Node aka = table.getElementsByTagName("aka").item(0);
			table.removeChild(aka);  
		} catch (ParserConfigurationException e){
			logger.error("Cannot parse file.");
		} catch(IOException ex){
			logger.error("Cannot read input file.");
		} finally {
			return doc;
		}
	}
}
