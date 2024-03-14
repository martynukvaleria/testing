package web.elements;

import core.DriverUtils;

public class Slider extends PageElement{
    public Slider(String name, String locator) {
        super(name, locator);
    }
    public void moveToRight(Integer value){
        DriverUtils.moveToRight(locator, value);
    }
    public void moveToLeft(Integer value){
        DriverUtils.moveToLeft(locator, value);
    }
}
