package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

// page_url = https://the-internet.herokuapp.com/checkboxes
public class CheckboxesPage {
    @FindBy(css = "form#checkboxes input[type='checkbox']:nth-of-type(1)")
    public WebElement checkbox1;

    @FindBy(css = "form#checkboxes input[type='checkbox']:nth-of-type(2)")
    public WebElement checkbox2;

    public CheckboxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
