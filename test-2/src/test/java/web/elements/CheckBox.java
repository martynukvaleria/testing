package web.elements;

import core.DriverUtils;

public class CheckBox extends  PageElement{
    public CheckBox(String name, String locator) {
        super(name, locator);
    }
    public void waitForClick(){
        DriverUtils.waitForBeClickable(locator);
    }
}
