package web;

import web.elements.Button;

// page_url = https://www.google.com/
public class GooglePage {
    public Button searchArea = new Button("//textarea[@class=\"gLFyf\"]");

    public GooglePage(){
        super();
    }
    public void sendKeysToSearch(String text){
        searchArea.sendKeys(text);
    }
    public void click() {
        searchArea.click();
    }
    public void waitForPageLoading(){
        searchArea.waitForVisibility();
    }
}
