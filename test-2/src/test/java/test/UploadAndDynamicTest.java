package test;

import core.ConfigUtils;
import core.DriverUtils;
import org.testng.annotations.*;
import web.ElementsPage;

import static org.testng.Assert.*;

public class UploadAndDynamicTest {
    ElementsPage testingPage = new ElementsPage();

    @BeforeMethod
    public void before() throws Throwable {
        DriverUtils.maxSize();
        DriverUtils.navigateToUrl(ConfigUtils.getValue("url.second"));
    }

    @org.testng.annotations.Test
    public void test() throws Throwable {

        testingPage.sendFileToUpload();
        assertTrue(testingPage.resultPathContainsName());

        testingPage.openDynamicPage();
        testingPage.clickButtonAfterWait();

        testingPage.reloadPage();
        testingPage.checkColorButtonChanged();

        testingPage.reloadPage();
        testingPage.clickButtonAfterAppearance();
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
