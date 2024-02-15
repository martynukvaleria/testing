package org.example.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://the-internet.herokuapp.com/add_remove_elements/
public class AddAndRemovePage {
    @FindBy(xpath = "//button[text()='Add Element']")
    public WebElement AddButton;

    @FindBy(xpath ="//button[text()='Delete']")
    public WebElement RemoveButton;

    public AddAndRemovePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
