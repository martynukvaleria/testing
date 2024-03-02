package web.elements;

import core.DriverUtils;

public abstract class PageElement {
    protected String name;
    protected String locator;

    public PageElement(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public void click() {
        DriverUtils.click(locator);
    }

    public boolean isDisplayed() {
        DriverUtils.waitForOpen(locator);
        return !DriverUtils.findElementsByXpath(locator).isEmpty();
    }

    public String getText() {
        return DriverUtils.findElementByXpath(locator).getText();
    }
}
