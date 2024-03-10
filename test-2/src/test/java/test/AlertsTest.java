package test;

import core.ConfigUtils;
import core.DriverUtils;
import core.XmlReader;
import org.testng.annotations.*;
import web.AlertsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AlertsTest {
    AlertsPage alertsPage = new AlertsPage();

    @BeforeMethod
    public void before() throws Throwable {
        DriverUtils.maxSize();
        DriverUtils.navigateToUrl(ConfigUtils.getValue("url.alerts"));
    }

    @Test
    public void test() throws Throwable {
        alertsPage.clickNewTab();
        assertEquals(alertsPage.getNewTabText(), ConfigUtils.getValue("new_tab_window_text"));
        alertsPage.closeNewTab();

        alertsPage.clickNewWindow();
        assertEquals(alertsPage.getNewWindowText(), ConfigUtils.getValue("new_tab_window_text"));
        alertsPage.closeNewWindow();

        alertsPage.openAlertsPage();
        alertsPage.clickOkOnSimpleAlert();

        alertsPage.clickCancelOnConfirmAlert();
        assertTrue(alertsPage.getConfirmAlertText().contains("Cancel"));

        alertsPage.clickAndEnterOnPromptAlert();
        assertTrue(alertsPage.getPromptAlertText().contains(ConfigUtils.getValue("username1")));
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
