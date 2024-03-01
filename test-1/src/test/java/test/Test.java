package test;

import core.DriverUtils;
import org.testng.annotations.*;

import web.GooglePage;
import web.MainPage;
//import web.SearchResultPage;

import static org.testng.Assert.*;

public class Test {

    GooglePage googlePage;
//    SearchResultPage searchResultPage = new SearchResultPage();
    MainPage mainPage = new MainPage();

    @BeforeMethod
    public void before() throws Throwable {
        DriverUtils.maxSize();
        googlePage = new GooglePage();
        DriverUtils.navigateToUrl("https://www.google.com/");
    }

    @org.testng.annotations.Test
    public void test() throws Throwable {
        googlePage.waitForPageLoading();
        googlePage.click();
        googlePage.sendKeysToSearch("testingchallenges.thetestingmap.org");

        googlePage.searchArea.clickEnter(googlePage.searchArea.getLocator());
        DriverUtils.navigateToUrl("http://testingchallenges.thetestingmap.org/");

//        searchResultPage.lookForResult();
//        assertFalse(searchResultPage.isResultEmpty());
//        searchResultPage.clickFirst();

//        assertTrue(mainPage.waitForPageLoading());
//        mainPage.clickSubmit();
//        assertEquals(mainPage.getResult(), "Empty value");
//        mainPage.inputName("abc");
//        mainPage.clickSubmit();
//        assertEquals(mainPage.getResult(), "Average value");
    }
//
    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}