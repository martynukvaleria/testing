package web;
import web.elements.Button;
import web.elements.Input;
import web.elements.TextField;

// page_url = http://testingchallenges.thetestingmap.org/
public class MainPage {
    public static TextField blueArea = new TextField("//div[@class=\"spec\"]");
    public static Button submitButton = new Button("//input[@type=\"submit\"]");
    public static Input inputNameArea = new Input("//input[@id=\"firstname\"]");
    public static TextField result = new TextField("/html/body/div[2]/div/div/div[2]/div/ul/li[1]");

    public MainPage() {
        super();
    }
    public void waitForPageLoading(){
        blueArea.waitForVisibility();
    }
}
