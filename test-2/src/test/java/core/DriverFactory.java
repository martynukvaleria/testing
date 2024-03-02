package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    WebDriver driver;

    public WebDriver getDriver(String browserType) {
        if (driver == null) {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    return driver = new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return driver = new FirefoxDriver();
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    return driver = new EdgeDriver();
                default:
                    throw new RuntimeException();
            }
        }
        return driver;
    }
}