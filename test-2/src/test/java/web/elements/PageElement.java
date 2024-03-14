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

    public void waitForAppearance() {
        DriverUtils.waitForOpen(locator);
    }

    public String getText() {
        return DriverUtils.findElementByXpath(locator).getText();
    }

    public void scrollToElement() {
        DriverUtils.scrollToElement(locator);
    }

    public String getValue() {
        return DriverUtils.getValue(locator);
    }

    public void clickEnter() {
        DriverUtils.clickEnter(locator);
    }

    public String returnResultColors() {
        String res = "";
        int n = DriverUtils.findElementsByXpath(locator).size();
        for (int i = 0; i < n; ++i) {
            res += DriverUtils.findElementsByXpath(locator).get(i).getText();
            res += " ";
        }
        return res;
    }

    public boolean isVisible() {
        return !DriverUtils.findElementsByXpath(locator).isEmpty();
    }

    public void hover() {
        DriverUtils.hoverToElement(locator);
    }
}
