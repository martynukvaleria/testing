package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

// page_url = http://the-internet.herokuapp.com/inputs
public class InputPage {
    @FindBy(tagName = "input")
    public WebElement input;


    public InputPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
