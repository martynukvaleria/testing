package web;

import core.DriverUtils;
import core.XmlReader;
import web.elements.Button;
import web.elements.TextField;

public class AlertsPage {
    private final Button openAlertsMenu = new Button("open alerts menu", XmlReader.getAlertLocator("openAlertsMenuLocator"));
    private final Button openAlertsPage = new Button("open alerts page", XmlReader.getAlertLocator("openAlertsPageLocator"));
    private final Button newTab = new Button("new tab", XmlReader.getBrowserLocator("newTabLocator"));
    private final Button newWindow = new Button("new window", XmlReader.getBrowserLocator("newWindowLocator"));
    private final TextField newTabText = new TextField("new tab text", XmlReader.getBrowserLocator("newTabAndWindowTextLocator"));
    private final TextField newWindowText = new TextField("new window text", XmlReader.getBrowserLocator("newTabAndWindowTextLocator"));

    private final Button simpleAlertButton = new Button("simple alert", XmlReader.getAlertLocator("simpleAlertButtonLocator"));
    private final Button confirmAlertButton = new Button("confirm alert", XmlReader.getAlertLocator("confirmAlertButtonLocator"));
    private final TextField confirmResult = new TextField("confirm result", XmlReader.getAlertLocator("confirmResultLocator"));
    private final Button promptAlertButton = new Button("prompt alert", XmlReader.getAlertLocator("promptAlertButtonLocator"));
    private final TextField promptResult = new TextField("confirm result", XmlReader.getAlertLocator("promptResultLocator"));


    public void clickNewTab() {
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

    public void clickNewWindow() {
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
        DriverUtils.closeNewWindow();
    }

    public void openAlertsPage() {
        openAlertsMenu.waitForAppearance();
        openAlertsMenu.click();
        openAlertsPage.waitForAppearance();
        openAlertsPage.click();
    }

    public void clickOkOnSimpleAlert() {
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
