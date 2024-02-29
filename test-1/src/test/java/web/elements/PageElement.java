package web.elements;

import core.DriverUtils;
import org.openqa.selenium.WebElement;
 public abstract class PageElement {
    protected WebElement webElement;

    public PageElement(String locator) {
        this.webElement = DriverUtils.findElementByXpath(locator);
    }

    public void click() {
        webElement.click();
    }

    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    public void waitForVisibility() {
        DriverUtils.waitForOpen(webElement);
    }

    public String getText() {
        return webElement.getText();
    }
}
