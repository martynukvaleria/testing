package org.example.selenium;

import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class HoverPageTest {
    private WebDriver driver;
    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://the-internet.herokuapp.com/hovers");

        hoverPage = new HoverPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstUserCheck() {
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverPage.user1).perform();

        WebElement nameElement = hoverPage.user1.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        String name = nameElement.getText();
        Assert.assertEquals(name, "name: user1");

        WebElement linkElement = hoverPage.user1.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
        String url = linkElement.getAttribute("href");
        linkElement.click();

        int statusCode = checkStatusCode(url);
        Assert.assertNotEquals(statusCode, 404);

        driver.navigate().back();
    }

    @Test
    public void secondUserCheck() {
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverPage.user2).perform();

        WebElement nameElement = hoverPage.user2.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        String name = nameElement.getText();
        Assert.assertEquals(name, "name: user2");

        WebElement linkElement = hoverPage.user2.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a"));
        String url = linkElement.getAttribute("href");
        linkElement.click();

        int statusCode = checkStatusCode(url);
        Assert.assertNotEquals(statusCode, 404);

        driver.navigate().back();
    }

    @Test
    public void thirdUserCheck() {
        Actions builder = new Actions(driver);
        builder.moveToElement(hoverPage.user3).perform();

        WebElement nameElement = hoverPage.user3.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
        String name = nameElement.getText();
        Assert.assertEquals(name, "name: user3");

        WebElement linkElement = hoverPage.user3.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a"));
        String url = linkElement.getAttribute("href");
        linkElement.click();

        int statusCode = checkStatusCode(url);
        Assert.assertNotEquals(statusCode, 404);

        driver.navigate().back();
    }

    private int checkStatusCode(String url) {
        int statusCode = 0;

        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);

            statusCode = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return statusCode;
    }
}
