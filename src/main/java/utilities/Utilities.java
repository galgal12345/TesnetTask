package utilities;

import io.qameta.allure.Step;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class Utilities {

    @Step("getDataXML")
    public static String getDataXML(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fxmlFile = new File("Config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fxmlFile);
        } catch (Exception e) {
            System.out.println("exeption in reading xml file- " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
}
