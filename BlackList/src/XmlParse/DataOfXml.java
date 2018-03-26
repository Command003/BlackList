package XmlParse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.*;

public class DataOfXml {
    static List<String> elementname = new ArrayList<>();
    static List<String> elementvalue = new ArrayList<>();
    static List<String> value;

    public void parseXML(Document doc) {

        Element root = doc.getDocumentElement();
        //получим все элементы-потомки гдавного элемента
        Node first = getNoTextElement(root); //определяем имя элемента-потомка root
        NodeList nodeList = doc.getElementsByTagName(first.getNodeName());
        System.out.println("всего" + " " + nodeList.getLength() + " " + "потомков корневого элемента");
        // вызываем метод для заполнения списков,  содержащих названия столбцов таблиц

        // для каждой сущности из xml файла выбираем значения из заданных тегов

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            stepThough(node);

            Sorting sorting = new Sorting();
            value = sorting.toSort();
            ResurseXml.mapvalue.put(i, value);

            elementvalue.clear();
            elementname.clear();
        }
    }

    private Node getNoTextElement(Node elt) {

        for (Node ch = elt.getFirstChild(); ch != null; ch = ch.getNextSibling()) {
            if (ch.getNodeName() != "#text") {
                return ch;
            }
        }
        return null;
    }
    private   void stepThough(Node start) {
        if (start.getNodeName() != "#text" && getNoTextElement(start) == null) {
            elementname.add(start.getNodeName());
            elementvalue.add(start.getTextContent());
        }

        for (Node child = start.getFirstChild(); child != null; child = child.getNextSibling()) {
            stepThough(child);
        }
    }

}
