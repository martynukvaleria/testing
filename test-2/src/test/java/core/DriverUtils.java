package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DriverUtils {
    public static DriverFactory factory = new DriverFactory();
    public static ConfigUtils configUtils = new ConfigUtils();
    public static WebDriver driver = factory.getDriver(configUtils.getBrowser());


    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void waitForOpen(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findElementByXpath(locator)));
    }

    public static WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static void click(String locatorOfButton) {
        driver.findElement(By.xpath(locatorOfButton)).click();
    }

    public static void sendKeys(String text, String locator) {
        DriverUtils.findElementByXpath(locator).sendKeys(text);
    }

    public static void maxSize() {
        driver.manage().window().maximize();
    }

    public static void quit() {
        driver.quit();
    }

    public static void clear(String xpath) {
        driver.findElement(By.xpath(xpath)).clear();
    }
}
