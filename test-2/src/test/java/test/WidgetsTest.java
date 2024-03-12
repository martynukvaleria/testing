package test;

import core.ConfigUtils;
import core.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.WidgetsPage;

import static org.testng.Assert.assertEquals;

public class WidgetsTest {
    WidgetsPage widgetsPage = new WidgetsPage();

    @BeforeMethod
    public void before() throws Throwable {
        DriverUtils.maxSize();
        DriverUtils.navigateToUrl(ConfigUtils.getValue("url.alerts"));
    }

    @Test
    public void test() throws Throwable {
//        widgetsPage.goToAutoCompletePage();
//        widgetsPage.typeMultipleColors("red");
//        widgetsPage.typeMultipleColors("black");
//        widgetsPage.typeMultipleColors("green");

        widgetsPage.goToDatePickerPage();
        widgetsPage.enterFirstDate();
        assertEquals(widgetsPage.getFirstDate(), "06/15/2000");

//        widgetsPage.enterSecondDate();
//        assertEquals(widgetsPage.getSecondDate(), "June 15, 2000 12:00 PM");
        widgetsPage.goToSliderPage();
        widgetsPage.moveSliderToRight(20);
         assertEquals(widgetsPage.getMoveResult(), "45");
        widgetsPage.moveSliderToLeft(5);
        assertEquals(widgetsPage.getMoveResult(), "40");

        widgetsPage.goToToolTipsPage();
//        widgetsPage.checkHoverToText();
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
