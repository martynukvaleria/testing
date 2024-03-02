package test;

import core.ConfigUtils;
import core.DriverUtils;
import org.testng.annotations.*;
import web.TestingPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Test {
    TestingPage testingPage = new TestingPage();

    @BeforeMethod
    public void before() throws Throwable {
        DriverUtils.maxSize();
        DriverUtils.navigateToUrl(DriverUtils.configUtils.getApplicationUrl());
    }

    @org.testng.annotations.Test
    public void test() throws Throwable {
        testingPage.openMenuButton.click();
//        testingPage.openCheckBoxPage.waitForAppearance();
//        testingPage.openCheckBoxPage.click();
//        testingPage.openHomeMenu.click();
//        testingPage.openDocumentsMenu.waitForAppearance();
//        testingPage.openDocumentsMenu.click();
//        testingPage.openOfficeMenu.click();
//        testingPage.privateCheckBox.waitForAppearance();
//        //cant click
//        testingPage.privateCheckBox.click();
//        testingPage.selectionResult.waitForAppearance();
//        assertEquals(testingPage.getResult(), DriverUtils.configUtils.getResult());

        testingPage.openCheckBoxPage.waitForAppearance();
        testingPage.openWebTablePage.click();
        for(int i = 0;i < 3; i++){
            testingPage.deleteInfo.waitForAppearance();
            testingPage.deleteInfo.click();
        }
        testingPage.addButton.click();

        testingPage.firstName.waitForAppearance();
        testingPage.firstName.sendKeys(DriverUtils.configUtils.getData("username1"));
        testingPage.lastName.sendKeys(DriverUtils.configUtils.getData("userLastName1"));
        testingPage.email.sendKeys(DriverUtils.configUtils.getData("userEmail"));
        testingPage.age.sendKeys(DriverUtils.configUtils.getData("userAge"));
        testingPage.salary.sendKeys(DriverUtils.configUtils.getData("userSalary"));
        testingPage.department.sendKeys(DriverUtils.configUtils.getData("userDepartment"));
        testingPage.submitButton.click();

        testingPage.firstNameCell.waitForAppearance();
        assertEquals(testingPage.firstNameCell.getText(), DriverUtils.configUtils.getData("username1"));
        assertEquals(testingPage.salaryCell.getText(), DriverUtils.configUtils.getData("userSalary"));

        testingPage.editButton.click();
        testingPage.firstName.waitForAppearance();
        testingPage.firstName.clear();
        testingPage.firstName.sendKeys(DriverUtils.configUtils.getData("username3"));
        testingPage.submitButton.click();
        testingPage.firstName.waitForAppearance();
        assertEquals(testingPage.firstNameCell.getText(), DriverUtils.configUtils.getData("username3"));

        testingPage.addButton.click();
        testingPage.firstName.waitForAppearance();
        testingPage.firstName.sendKeys(DriverUtils.configUtils.getData("username2"));
        testingPage.lastName.sendKeys(DriverUtils.configUtils.getData("userLastName2"));
        testingPage.email.sendKeys(DriverUtils.configUtils.getData("userEmail"));
        testingPage.age.sendKeys(DriverUtils.configUtils.getData("userAge"));
        testingPage.salary.sendKeys(DriverUtils.configUtils.getData("userSalary"));
        testingPage.department.sendKeys(DriverUtils.configUtils.getData("userDepartment"));
        testingPage.submitButton.click();

        testingPage.searchField.sendKeys(DriverUtils.configUtils.getData("userLastName2"));
        assertEquals(testingPage.lastNameCell.getText(), DriverUtils.configUtils.getData("userLastName2"));

    }

    @AfterMethod
    public void tearDown() {
        DriverUtils.quit();
    }
}
