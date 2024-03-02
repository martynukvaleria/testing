package web.elements;


import core.DriverUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Link extends PageElement {
    public Link(String name, String locator) {
        super(name, locator);
    }

    public List<WebElement> getListOfLinks(){
        return DriverUtils.findElementsByXpath(locator);
    }
}