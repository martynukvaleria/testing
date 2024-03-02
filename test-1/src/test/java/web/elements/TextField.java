package web.elements;

import core.DriverUtils;

public class TextField extends PageElement {
    public TextField(String name, String locator) {
        super(name, locator);
    }
    public void sendKeys(String text){
        DriverUtils.sendKeys(text, locator);
    }

    public void clickEnter() {
        DriverUtils.clickEnter(locator);
    }
}