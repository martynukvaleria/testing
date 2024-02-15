package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckboxesPageTest {
    private WebDriver driver;
    private CheckboxesPage checkboxesPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        checkboxesPage = new CheckboxesPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstChecked() {
        Assert.assertFalse(checkboxesPage.checkbox1.isSelected());
        checkboxesPage.checkbox1.click();
        Assert.assertTrue(checkboxesPage.checkbox1.isSelected());
    }


    @Test
    public void secondChecked() {
        Assert.assertTrue(checkboxesPage.checkbox2.isSelected());
        checkboxesPage.checkbox2.click();
        Assert.assertFalse(checkboxesPage.checkbox2.isSelected());
    }

}
