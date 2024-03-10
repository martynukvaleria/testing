package web;

import core.DriverUtils;
import web.elements.Button;
import web.elements.TextField;

import java.util.Collection;

public class AlertsPage {
    private final String openAlertsMenuLocator = "//div[@class=\"element-group\"][3]";
    private final String openAlertsPageLocator = "//div[@class=\"element-group\"][3]//li[@id=\"item-1\"]";
    private final Button openAlertsMenu = new Button("open alerts menu", openAlertsMenuLocator);
    private final Button openAlertsPage = new Button("open alerts page", openAlertsPageLocator);
    //browser
    private final String newTabLocator = "//button[@id=\"tabButton\"]";
    private final String newWindowLocator = "//button[@id=\"windowButton\"]";
    private final String newTabAndWindowTextLocator = "//h1[@id=\"sampleHeading\"]";

    //alerts
    private final String simpleAlertButtonLocator = "//button[@id=\"alertButton\"]";
    private final String confirmAlertButtonLocator = "//button[@id=\"confirmButton\"]";
    private final String confirmResultLocator = "//span[@id=\"confirmResult\"]";
    private final String promptAlertButtonLocator = "//button[@id=\"promtButton\"]";
    private final String promptResultLocator = "//span[@id=\"promptResult\"]";
    //browser
    private final Button newTab = new Button("new tab", newTabLocator);
    private final Button newWindow = new Button("new window", newWindowLocator);
    private final TextField newTabText = new TextField("new tab text", newTabAndWindowTextLocator);
    private final TextField newWindowText = new TextField("new window text", newTabAndWindowTextLocator);

    //alerts
    private final Button simpleAlertButton = new Button("simple alert", simpleAlertButtonLocator);
    private final Button confirmAlertButton = new Button("confirm alert", confirmAlertButtonLocator);
    private final TextField confirmResult = new TextField("confirm result", confirmResultLocator);
    private final Button promptAlertButton = new Button("prompt alert", promptAlertButtonLocator);
    private final TextField promptResult = new TextField("confirm result", promptResultLocator);


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
        DriverUtils.closeCurrentTabOrWindow();
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
        DriverUtils.closeCurrentTabOrWindow();
        DriverUtils.switchToNewWindow();
    }
    public void openAlertsPage() {
        openAlertsMenu.waitForAppearance();
        openAlertsMenu.click();
        openAlertsPage.waitForAppearance();
        openAlertsPage.click();
    }

    public void clickOkOnSimpleAlert(){
        simpleAlertButton.waitForAppearance();
        simpleAlertButton.click();
        DriverUtils.clickOkOnAlert();
    }

    public void clickCancelOnConfirmAlert() {
        confirmAlertButton.waitForAppearance();
        confirmAlertButton.click();
        DriverUtils.clickCancelOnAlert();
    }

    public String getConfirmAlertText() {
        return confirmResult.getText();
    }

    public void clickAndEnterOnPromptAlert() {
        promptAlertButton.waitForAppearance();
        promptAlertButton.click();
        DriverUtils.enterNameToPromptAlert();
    }

    public String getPromptAlertText() {
        return promptResult.getText();
    }
}
