package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;


public class DriverUtils {
    public static DriverFactory factory = new DriverFactory();
    public static WebDriver driver = factory.getDriver(ConfigUtils.getValue("browser"));

    public static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void waitForOpen(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
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

    public static void scrollToElement(String xpath) {
        WebElement element = findElementByXpath(xpath);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void sendFileToUpload(String xpath) {
        driver.findElement(By.xpath(xpath)).sendKeys(System.getProperty("user.dir") + ConfigUtils.getValue("filepath"));
    }

    public static String getColor(String xpath) {
        return driver.findElement(By.xpath(xpath)).getCssValue("color");
    }

    public static void reloadPage() {
        driver.navigate().refresh();
    }

    public static void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public static void switchToNewWindow() {
        ArrayList<String> win = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(win.get(win.size() - 1));
    }

    public static void closeCurrentTabOrWindow() {
        driver.close();
    }

    public static void clickOkOnAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void clickCancelOnAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public static void enterNameToPromptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(ConfigUtils.getValue("username1"));
        alert.accept();
    }

    public static void closeNewWindow() {
        closeCurrentTabOrWindow();
        switchToNewWindow();
    }
    public static String getValue(String xpath){
        return driver.findElement(By.xpath(xpath)).getAttribute("value");
    }

    public static boolean isVisible(String xpath) {
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }
}
