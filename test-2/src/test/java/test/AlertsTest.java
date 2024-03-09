package test;

import core.ConfigUtils;
import core.DriverUtils;
import org.testng.annotations.*;
import web.AlertsPage;

import static org.testng.Assert.assertEquals;


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
        assertEquals(alertsPage.getNewTabText(), "This is a sample page");
        alertsPage.closeNewTab();

        alertsPage.clickNewWindow();
        assertEquals(alertsPage.getNewWindowText(), "This is a sample page");
        alertsPage.closeNewWindow();
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
