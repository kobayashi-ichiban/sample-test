package jp.exercise;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class xmlReader {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("D:\\VSCode\\iTunes Music Library.xml");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            if (document.hasChildNodes()) {
                printNote(document.getChildNodes());
            }
        } catch (ParserConfigurationException e) {
            System.out.println("--ParserConfigurationException--");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("--IOException--");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("--SAXException--");
            e.printStackTrace();
        }
    }

    private static void printNote(NodeList nodeList) {
        for (int count=0; count <nodeList.getLength(); count++) {
            Node tmpNode = nodeList.item(count);
            if (tmpNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println("[OPEN]NodeName: " + tmpNode.getNodeName());
                if (tmpNode.hasAttributes()) {
                    NamedNodeMap nodeMap = tmpNode.getAttributes();
                    for (int i=0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        System.out.println("node name: " + node.getNodeName());
                        System.out.println("node value: " + node.getNodeValue());
                    }
                }
                if (tmpNode.hasChildNodes()) {
                    printNote(tmpNode.getChildNodes());
                }
                System.out.println("[CLOSE]NodeName: " + tmpNode.getNodeName());
            }
        }
    }
}
