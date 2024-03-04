package test;

import core.ConfigUtils;
import core.DriverUtils;
import org.testng.annotations.*;
import web.TestingPage;

import static org.testng.Assert.assertEquals;

public class Test {
    TestingPage testingPage = new TestingPage();

    @BeforeMethod
    public void before() throws Throwable {
        DriverUtils.maxSize();
        DriverUtils.navigateToUrl(ConfigUtils.getProperty("url.base"));
    }

    @org.testng.annotations.Test
    public void test() throws Throwable {
        testingPage.selectCheckBoxPrivate();
        assertEquals(testingPage.getResult(), ConfigUtils.getProperty("result"));

        testingPage.openWebTablePage();
        testingPage.clickDeleteTrice();

        testingPage.fillFirstUserData();
        assertEquals(testingPage.firstNameCell.getText(), ConfigUtils.getProperty("username1"));
        assertEquals(testingPage.salaryCell.getText(), ConfigUtils.getProperty("userSalary"));

        testingPage.changeFirstUserName();
        assertEquals(testingPage.firstNameCell.getText(), ConfigUtils.getProperty("username3"));

        testingPage.fillSecondUserData();

        testingPage.searchField.sendKeys(ConfigUtils.getProperty("userLastName2"));
        assertEquals(testingPage.lastNameCell.getText(), ConfigUtils.getProperty("userLastName2"));
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
