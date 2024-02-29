package web.elements;

public class Button extends PageElement {
    public Button(String locator) {
        super(locator);
    }
    public void sendKeys(String text) {
        webElement.sendKeys(text);
    }
}
