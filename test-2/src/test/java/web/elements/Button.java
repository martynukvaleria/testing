package web.elements;

import core.DriverUtils;

public class Button extends PageElement {
    public Button(String name, String locator) {
        super(name, locator);
    }

    public void waitForClick(){
        DriverUtils.waitForBeClickable(locator);
    }
}