package org.example.selenium;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class AddAndRemovePageTest {
    private WebDriver driver;
    private AddAndRemovePage addAndRemovePage;

    public int count(String path){
        List<WebElement> elements = driver.findElements(By.xpath(path));
        return elements.size();
    }

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        addAndRemovePage = new AddAndRemovePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void add() {
        addAndRemovePage.AddButton.click();
        assertEquals(count("//button[text()='Delete']"), 1);
    }
    @Test
    public void remove(){
        addAndRemovePage.AddButton.click();
        addAndRemovePage.RemoveButton.click();
        assertEquals(count("//button[text()='Delete']"), 0);
    }

}
