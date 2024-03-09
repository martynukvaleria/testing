package web;

import core.DriverUtils;
import web.elements.Button;
import web.elements.TextField;

public class AlertsPage {
    private String newTabLocator = "//button[@id=\"tabButton\"]";
    private String newWindowLocator = "//button[@id=\"windowButton\"]";
    private String newTabAndWindowTextLocator = "//h1[@id=\"sampleHeading\"]";

    private Button newTab = new Button("new tab", newTabLocator);
    private Button newWindow = new Button("new window", newWindowLocator);
    private TextField newTabText = new TextField("new tab text", newTabAndWindowTextLocator);
    private TextField newWindowText = new TextField("new window text", newTabAndWindowTextLocator);

    public void clickNewTab(){
        newTab.waitForAppearance();
        newTab.click();
    }
    public String getNewTabText() {
        DriverUtils.switchToNewTab();
        newTabText.waitForAppearance();
        return newTabText.getText();
    }

    public void closeNewTab() {
        DriverUtils.closeCurrentTab();
        DriverUtils.switchToNewTab();
    }

    public void clickNewWindow(){
        newWindow.waitForAppearance();
        newWindow.scrollToElement();
        newWindow.click();
    }

    public String getNewWindowText() {
        DriverUtils.switchToNewWindow();
        DriverUtils.maxSize();
        newWindowText.waitForAppearance();
        return newWindowText.getText();
    }

    public void closeNewWindow() {
        DriverUtils.closeCurrentWindow();
        DriverUtils.switchToNewWindow();
    }
}
