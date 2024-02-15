package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropdownPageTest {
    private WebDriver driver;
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/dropdown");

        dropdownPage = new DropdownPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstSelected() {
        dropdownPage.getOptions().getFirst().click();
        Assert.assertTrue(dropdownPage.getOptions().getFirst().isSelected());
    }


    @Test
    public void secondSelected() {
        dropdownPage.getOptions().get(1).click();
        Assert.assertTrue(dropdownPage.getOptions().get(1).isSelected());
    }

}
