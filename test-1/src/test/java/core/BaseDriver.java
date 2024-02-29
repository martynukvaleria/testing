package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseDriver {
    public static WebDriver driver = null;
    public static void initialize() {
        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    public static void quit(){
        driver.quit();
    }

    public void get(String url) {
        driver.get(url);
    }

    public WebElement findElement(By xpath) {
        return driver.findElement(xpath);
    }

    public List<WebElement> findElements(By xpath) {
        return driver.findElements(xpath);
    }
}
