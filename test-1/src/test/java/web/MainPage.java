package web;
import web.elements.*;


// page_url = http://testingchallenges.thetestingmap.org/
public class MainPage {
    public static TextField blueArea = new TextField("blue area", "//div[@class=\"spec\"]");
    public static Button submitButton = new Button("submit button", "//input[@type=\"submit\"]");
    public static TextField inputNameArea = new TextField("input name area", "//input[@id=\"firstname\"]");
    public static TextField result = new TextField("result area", "//ul[@class=\"values-description t10\"]//li");

    public boolean waitForPageLoading(){
        return blueArea.isDisplayed();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public String getResult() {
        return result.getText();
    }

    public void inputName(String name) {
        inputNameArea.sendKeys(name);
    }
}
