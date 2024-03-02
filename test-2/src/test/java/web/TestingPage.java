package web;

import core.DriverUtils;
import web.elements.Button;
import web.elements.CheckBox;
import web.elements.TextField;

public class TestingPage {
    public Button openMenuButton = new Button("open main menu", DriverUtils.configUtils.getLocator("openMenuLocator"));
    public Button openCheckBoxPage = new Button("open checkbox page", DriverUtils.configUtils.getLocator("checkBoxPageLocator"));
    public Button openHomeMenu = new Button("open home menu", DriverUtils.configUtils.getLocator("openHomeLocator"));
    public Button openDocumentsMenu = new Button("open documents menu", DriverUtils.configUtils.getLocator("openDocumentsLocator"));
    public Button openOfficeMenu = new Button("open office menu", DriverUtils.configUtils.getLocator("openOfficeLocator"));
    public CheckBox privateCheckBox = new CheckBox("private option", DriverUtils.configUtils.getLocator("privateCheckBoxLocator"));
    public TextField selectionResult = new TextField("result", DriverUtils.configUtils.getLocator("selectionResultLocator"));

    //web table
    public Button openWebTablePage = new Button("open webtable page", DriverUtils.configUtils.getLocator("webTablePageLocator"));
    public Button deleteInfo = new Button("delete", DriverUtils.configUtils.getLocator("deleteInfoLocator"));
    public Button addButton = new Button("add", DriverUtils.configUtils.getLocator("addButtonLocator"));

    public TextField firstName = new TextField("first name", DriverUtils.configUtils.getLocator("firstNameLocator"));
    public TextField lastName = new TextField("last name", DriverUtils.configUtils.getLocator("lastNameLocator"));
    public TextField email = new TextField("email", DriverUtils.configUtils.getLocator("emailLocator"));
    public TextField age = new TextField("age", DriverUtils.configUtils.getLocator("ageLocator"));
    public TextField salary = new TextField("salary", DriverUtils.configUtils.getLocator("salaryLocator"));
    public TextField department = new TextField("department", DriverUtils.configUtils.getLocator("departmentLocator"));
    public Button submitButton = new Button("submit", DriverUtils.configUtils.getLocator("submitButtonLocator"));
    public TextField firstNameCell = new TextField("first name cell", DriverUtils.configUtils.getLocator("firstNameCellLocator"));
    public TextField lastNameCell = new TextField("last name cell", DriverUtils.configUtils.getLocator("lastNameCellLocator"));
    public TextField salaryCell = new TextField("salary cell", DriverUtils.configUtils.getLocator("salaryCellLocator"));

    public Button editButton = new Button("edit button", DriverUtils.configUtils.getLocator("editButtonLocator"));
    public TextField searchField = new TextField("search field", DriverUtils.configUtils.getLocator("searchFieldLocator"));

    public String getResult() {
        return selectionResult.getText();
    }
}


