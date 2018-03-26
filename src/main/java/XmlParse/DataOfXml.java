package XmlParse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.*;




public class DataOfXml {

static   List<String> elementname =new ArrayList<>();
static   List<String> elementvalue =new ArrayList<>();

static   List<String> value;

 void parseXML(Document doc) {

        Element root = doc.getDocumentElement();
        System.out.println("корневой элемент" + " " + root.getNodeName());
        //получим все элементы-потомки гдавного элемента
        Node first = getNoTextElement(root); //определяем имя элемента-потомка root
        NodeList nodeList = doc.getElementsByTagName(first.getNodeName());
        System.out.println("всего" + " " + nodeList.getLength() + " " + "потомков корневого элемента");
        // вызываем метод для заполнения списков,  содержащих названия столбцов таблиц

        // для каждой сущности из xml файла выбираем значения из заданных тегов

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            stepThough(node);
         // for(String s:elementvalue){System.out.println(s);}
         //   System.out.println();

            Sorting sorting =new Sorting();
            value=sorting.toSort();

         //   for(String s:value){System.out.println(s);}
         //   System.out.println();

            ResurseXml.mapvalue.put(i,value);

            elementvalue.clear();
            elementname.clear();
        }
    }


  Node getNoTextElement(Node elt) {

    for (Node ch = elt.getFirstChild(); ch != null; ch = ch.getNextSibling()) {
        if (ch.getNodeName() != "#text") {

            return ch;
        }
    }
    return null;
}


   public void stepThough(Node start) {


    if (start.getNodeName() != "#text" && getNoTextElement(start) == null) {
       // System.out.println(start.getNodeName() + " " + start.getTextContent());

        elementname.add(start.getNodeName());
        elementvalue.add(start.getTextContent());




    }
    for (Node child = start.getFirstChild(); child != null; child = child.getNextSibling()) {
        stepThough(child);
    }


}





}
