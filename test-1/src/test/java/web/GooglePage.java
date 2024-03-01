package web;


import web.elements.TextField;

// page_url = https://www.google.com/
public class GooglePage {
    public TextField searchArea = new TextField("text", "//textarea[@class=\"gLFyf\"]");
    public void sendKeysToSearch(String text) {
        searchArea.sendKeys(text);
    }

    public void click() {
        searchArea.click();
    }

    public boolean waitForPageLoading() {
        return searchArea.isDisplayed();
    }
}
