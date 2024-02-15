package org.example.selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InputPageTest {
    private WebDriver driver;
    private InputPage inputPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://the-internet.herokuapp.com/inputs");

        inputPage = new InputPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void enterCheck() {
        inputPage.input.sendKeys("123");
        Assert.assertEquals(inputPage.input.getAttribute("value"), "123");
    }
    @Test
    public void pressUpCheck() {
        inputPage.input.sendKeys("123");
        inputPage.input.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputPage.input.getAttribute("value"), "124");
    }
    @Test
    public void pressDownCheck(){
        inputPage.input.sendKeys("124");
        inputPage.input.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(inputPage.input.getAttribute("value"), "123");
    }

}
