package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverUtils {
        public static BaseDriver driver;
//    public static WebDriver driver;

    public DriverUtils(BaseDriver driver) {
        DriverUtils.driver = driver;
    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void waitForOpen(WebElement element) {
        WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static List<WebElement> findElementsByXpath(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }
}
