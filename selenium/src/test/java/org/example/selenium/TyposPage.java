package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

// page_url = http://the-internet.herokuapp.com/typos
public class TyposPage {
    @FindBy(tagName = "p")
    public WebElement text;

    public TyposPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
