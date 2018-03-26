package XmlParse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class DocumentBuild {  private Document doc;
    // Строим объектную модель исходного XML файла
    String as = ResurseXml.ph;

    public  Document createDocument() {

        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(as);

            // Выполнять нормализацию не обязательно, но рекомендуется
            // doc.getDocumentElement().normalize();

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
            return  doc;
        }
    }
}
