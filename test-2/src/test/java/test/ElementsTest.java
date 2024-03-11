package test;

import core.ConfigUtils;
import core.DriverUtils;
import org.testng.annotations.*;
import web.ElementsPage;

import static org.testng.Assert.assertEquals;

public class ElementsTest {
    ElementsPage testingPage = new ElementsPage();

    @BeforeMethod
    public void before() throws Throwable {
        DriverUtils.maxSize();
        DriverUtils.navigateToUrl(ConfigUtils.getValue("url.base"));
    }

    @org.testng.annotations.Test
    public void test() throws Throwable {
        testingPage.selectCheckBoxPrivate();
        assertEquals(testingPage.getResult(), ConfigUtils.getValue("result"));

        testingPage.openWebTablePage();
        testingPage.clickDeleteTrice();

        testingPage.fillFirstUserData();
        assertEquals(testingPage.firstNameCell.getText(), ConfigUtils.getValue("username1"));
        assertEquals(testingPage.salaryCell.getText(), ConfigUtils.getValue("userSalary"));

        testingPage.changeFirstUserName();
        assertEquals(testingPage.firstNameCell.getText(), ConfigUtils.getValue("username3"));

        testingPage.fillSecondUserData();

        testingPage.searchField.sendKeys(ConfigUtils.getValue("userLastName2"));
        assertEquals(testingPage.lastNameCell.getText(), ConfigUtils.getValue("userLastName2"));
    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
