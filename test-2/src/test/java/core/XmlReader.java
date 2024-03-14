package core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.MalformedURLException;

public class XmlReader {
    static String pathXml = ConfigUtils.getValue("filepath_xml");
    static File inputFile = new File(System.getProperty("user.dir") + pathXml);
    static SAXReader saxReader = new SAXReader();
    static Document document;

    static {
        try {
            document = saxReader.read(inputFile);
        } catch (DocumentException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowserLocator(String name) {
        return document.selectSingleNode("//locators/browser/" + name).getText();
    }

    public static String getAlertLocator(String name) {
        return document.selectSingleNode("//locators/alert/" + name).getText();
    }

    public static String getAutoCompleteLocator(String name) {
        return document.selectSingleNode("//locators/autoComplete/" + name).getText();
    }

    public static String getDatePickerLocator(String name) {
        return document.selectSingleNode("//locators/datePicker/" + name).getText();
    }

    public static String getSliderLocator(String name) {
        return document.selectSingleNode("//locators/slider/" + name).getText();
    }

    public static String getToolTipsLocator(String name) {
        return document.selectSingleNode("//locators/toolTips/" + name).getText();
    }
}
