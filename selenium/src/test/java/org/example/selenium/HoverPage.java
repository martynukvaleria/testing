package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://the-internet.herokuapp.com/hovers
public class HoverPage {
    @FindBy(xpath = "//div[@class='figure'][1]/img")
    public WebElement user1;
    @FindBy(xpath = "//div[@class='figure'][2]/img")
    public WebElement user2;
    @FindBy(xpath = "//div[@class='figure'][3]/img")
    public WebElement user3;

    public HoverPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
