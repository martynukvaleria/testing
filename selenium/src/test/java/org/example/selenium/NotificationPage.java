package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://the-internet.herokuapp.com/notification_message_rendered
public class NotificationPage {
    @FindBy(css = "a[href='/notification_message']")
    public WebElement button;
     @FindBy(css = "#flash-messages")
     public WebElement message;
    public NotificationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
