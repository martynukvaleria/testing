package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataTablePageTest {
    private WebDriver driver;
    private DataTablePage dataTablePage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://the-internet.herokuapp.com/tables");

        dataTablePage = new DataTablePage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void contentCheck() {
        Assert.assertEquals(dataTablePage.cell1.getText(), "Smith");
        Assert.assertEquals(dataTablePage.cell2.getText(), "jsmith@gmail.com");
        Assert.assertEquals(dataTablePage.cell3.getText(), "$51.00");
    }

}
