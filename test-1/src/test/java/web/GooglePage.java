package web;


import web.elements.TextField;

// page_url = https://www.google.com/
public class GooglePage {

    private String locator = "//textarea[@class=\"gLFyf\"]";
    public TextField searchArea = new TextField("text", locator);
    public void sendKeysToSearch(String text) {
        searchArea.sendKeys(text);
    }

    public void clickSearch() {
        searchArea.click();
    }

    public boolean waitForPageLoading() {
        return searchArea.isDisplayed();
    }
}
