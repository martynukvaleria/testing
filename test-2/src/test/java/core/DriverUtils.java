package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class DriverUtils {
    public static DriverFactory factory = new DriverFactory();
    public static WebDriver driver = factory.getDriver(ConfigUtils.getValue("browser"));

    public static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void waitForOpen(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.visibilityOf(findElementByXpath(locator)));
    }

    public static void waitForBeClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.elementToBeClickable(findElementByXpath(locator)));
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

    public static void scrollToElement(String xpath) {
        WebElement element = findElementByXpath(xpath);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void sendFileToUpload(String xpath) {
        driver.findElement(By.xpath(xpath)).sendKeys(ConfigUtils.getValue("filepath"));
    }

    public static String getColor(String xpath) {
        return driver.findElement(By.xpath(xpath)).getCssValue("color");
    }
}
