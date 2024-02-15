package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NotificationPageTest {
    private WebDriver driver;
    private NotificationPage notificationPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");

        notificationPage = new NotificationPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void messageCheck() {
        Assert.assertEquals(notificationPage.message.getText(), "Action successful");
        notificationPage.button.click();
        Assert.assertEquals(notificationPage.message.getText(), "Action unsuccesful, please try again");
    }

}
