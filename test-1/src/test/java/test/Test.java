package test;

import core.BaseDriver;
//import core.DriverUtils;
import core.DriverUtils;
import org.testng.annotations.*;

import web.GooglePage;
import web.MainPage;
import web.SearchResultPage;

public class Test {

    GooglePage googlePage = new GooglePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void before() throws Throwable {
        BaseDriver.initialize();
        DriverUtils.navigateToUrl("https://www.google.com/");
    }

    @org.testng.annotations.Test
    public void test() throws Throwable {
        //Google search tests
        googlePage.waitForPageLoading();
        googlePage.click();
        googlePage.sendKeysToSearch("testingchallenges.thetestingmap.org");
        System.out.println("End");
//
////        assertFalse(searchResultPage.isResultEmpty());
////        searchResultPage.clickFirst();
////
////        //Main page tests
////        assertTrue(mainPage.isDisplayedBlueArea());
////        mainPage.clickSubmit();
////        assertEquals(mainPage.getResult(), "Empty value");
////        mainPage.inputName("abc");
////        assertEquals(mainPage.getResult(), "Average value");
    }

    @AfterClass
    public void tearDown() {
        BaseDriver.quit();
    }
}