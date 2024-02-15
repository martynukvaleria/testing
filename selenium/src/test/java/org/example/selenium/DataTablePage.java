package org.example.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://the-internet.herokuapp.com/tables
public class DataTablePage {
    @FindBy(xpath = "//table[@id='table1']//tr[1]//td[1]")
    public WebElement cell1;
    @FindBy(xpath = "//table[@id='table1']//tr[1]//td[3]")
    public WebElement cell2;
    @FindBy(xpath = "//table[@id='table2']//tr[2]//td[4]")
    public WebElement cell3;

    public DataTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
