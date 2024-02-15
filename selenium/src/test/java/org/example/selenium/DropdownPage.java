package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = https://the-internet.herokuapp.com/dropdown
public class DropdownPage {
    @FindBy(id = "dropdown")
    public WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public List<WebElement> getOptions() {
        return dropdown.findElements(By.tagName("option"));
    }
}
