package web;

import core.ConfigUtils;
import web.elements.Button;
import web.elements.CheckBox;
import web.elements.TextField;

public class TestingPage {

    //locators to string
    public String openMenuLocator = "//div[text()=\"Elements\"]";
    public String checkBoxPageLocator = "//li[@id=\"item-1\"]";
    public String openHomeLocator = "//button[@class=\"rct-collapse rct-collapse-btn\"]";
    public String openDocumentsLocator = "//span[text()=\"Documents\"]/ancestor::label/preceding-sibling::button";
    public String openOfficeLocator = "//span[text()=\"Office\"]/ancestor::label/preceding-sibling::button";
    public String privateCheckBoxLocator = "//span[text()=\"Private\"]/ancestor::label/span[@class=\"rct-checkbox\"]";
    public String selectionResultLocator = "//span[@class=\"text-success\"]";

    public Button openMenuButton = new Button("open main menu", openMenuLocator);
    public Button openCheckBoxPage = new Button("open checkbox page", checkBoxPageLocator);
    public Button openHomeMenu = new Button("open home menu", openHomeLocator);
    public Button openDocumentsMenu = new Button("open documents menu", openDocumentsLocator);
    public Button openOfficeMenu = new Button("open office menu", openOfficeLocator);
    public CheckBox privateCheckBox = new CheckBox("private option", privateCheckBoxLocator);
    public TextField selectionResult = new TextField("result", selectionResultLocator);

    //web table
    public String webTablePageLocator = "//li[@id=\"item-3\"]";
    public String deleteInfoLocator = "//span[contains(@id,\"delete-record\")]";
    public String addButtonLocator = "//button[@id=\"addNewRecordButton\"]";
    public String firstNameLocator = "//input[@id=\"firstName\"]";
    public String lastNameLocator = "//input[@id=\"lastName\"]";
    public String emailLocator = "//input[@id=\"userEmail\"]";
    public String ageLocator = "//input[@id=\"age\"]";
    public String salaryLocator = "//input[@id=\"salary\"]";
    public String departmentLocator = "//input[@id=\"department\"]";
    public String submitButtonLocator = "//button[@id=\"submit\"]";
    public String firstNameCellLocator = "//div[@class='rt-tbody']//div[@class='rt-tr -odd']//div[@role='gridcell'][1]";
    public String lastNameCellLocator = "//div[@class='rt-tbody']//div[@class='rt-tr -odd']//div[@role='gridcell'][2]";
    public String salaryCellLocator = "//div[@class='rt-tbody']//div[@class='rt-tr -odd']//div[@role='gridcell'][5]";
    public String editButtonLocator = "//*[@id=\"edit-record-1\"]";
    public String searchFieldLocator = "//input[@id=\"searchBox\"]";
    public Button openWebTablePage = new Button("open webtable page", webTablePageLocator);
    public Button deleteInfo = new Button("delete", deleteInfoLocator);
    public Button addButton = new Button("add", addButtonLocator);

    public TextField firstName = new TextField("first name", firstNameLocator);
    public TextField lastName = new TextField("last name", lastNameLocator);
    public TextField email = new TextField("email", emailLocator);
    public TextField age = new TextField("age", ageLocator);
    public TextField salary = new TextField("salary", salaryLocator);
    public TextField department = new TextField("department", departmentLocator);
    public Button submitButton = new Button("submit", submitButtonLocator);
    public TextField firstNameCell = new TextField("first name cell", firstNameCellLocator);
    public TextField lastNameCell = new TextField("last name cell", lastNameCellLocator);
    public TextField salaryCell = new TextField("salary cell", salaryCellLocator);

    public Button editButton = new Button("edit button", editButtonLocator);
    public TextField searchField = new TextField("search field", searchFieldLocator);

    public String getResult() {
        selectionResult.scrollToElement();
        selectionResult.waitForAppearance();
        return selectionResult.getText();
    }

    public void clickOpenCheckBoxPage() {
        openCheckBoxPage.scrollToElement();
        openCheckBoxPage.waitForAppearance();
        openCheckBoxPage.click();
    }

    public void clickOpenMenuButton() {
        openMenuButton.scrollToElement();
        openMenuButton.waitForAppearance();
        openMenuButton.click();
    }

    public void clickOpenHomeMenu() {
        openHomeMenu.scrollToElement();
        openHomeMenu.waitForAppearance();
        openHomeMenu.click();
    }

    public void clickOpenDocumentsMenu() {
        openDocumentsMenu.scrollToElement();
        openDocumentsMenu.waitForAppearance();
        openDocumentsMenu.click();
    }

    public void clickOpenOfficeMenu() {
        openOfficeMenu.scrollToElement();
        openOfficeMenu.waitForAppearance();
        openOfficeMenu.click();
    }

    public void clickPrivateCheckBox() {
        privateCheckBox.scrollToElement();
        privateCheckBox.waitForClick();
        privateCheckBox.click();
    }

    public void selectCheckBoxPrivate() {
        clickOpenMenuButton();
        clickOpenCheckBoxPage();
        clickOpenHomeMenu();
        clickOpenDocumentsMenu();
        clickOpenOfficeMenu();
        clickPrivateCheckBox();
    }

    public void clickDeleteTrice() {
        for (int i = 0; i < 3; i++) {
            deleteInfo.scrollToElement();
            deleteInfo.waitForAppearance();
            deleteInfo.click();
        }
    }

    public void fillFirstUserData() {
        addButton.scrollToElement();
        addButton.waitForAppearance();
        addButton.click();
        firstName.waitForAppearance();
        firstName.sendKeys(ConfigUtils.getValue("username1"));
        lastName.sendKeys(ConfigUtils.getValue("userLastName1"));
        email.sendKeys(ConfigUtils.getValue("userEmail"));
        age.sendKeys(ConfigUtils.getValue("userAge"));
        salary.sendKeys(ConfigUtils.getValue("userSalary"));
        department.sendKeys(ConfigUtils.getValue("userDepartment"));
        submitButton.click();
    }

    public void changeFirstUserName() {
        editButton.scrollToElement();
        editButton.waitForAppearance();
        editButton.click();
        firstName.waitForAppearance();
        firstName.clear();
        firstName.sendKeys(ConfigUtils.getValue("username3"));
        submitButton.click();
    }

    public void fillSecondUserData() {
        addButton.scrollToElement();
        addButton.click();
        firstName.waitForAppearance();
        firstName.sendKeys(ConfigUtils.getValue("username2"));
        lastName.sendKeys(ConfigUtils.getValue("userLastName2"));
        email.sendKeys(ConfigUtils.getValue("userEmail"));
        age.sendKeys(ConfigUtils.getValue("userAge"));
        salary.sendKeys(ConfigUtils.getValue("userSalary"));
        department.sendKeys(ConfigUtils.getValue("userDepartment"));
        submitButton.click();
        firstNameCell.waitForAppearance();
    }

    public void openWebTablePage() {
        openWebTablePage.scrollToElement();
        openWebTablePage.waitForAppearance();
        openWebTablePage.click();
    }
}


