package web;

import core.XmlReader;
import web.elements.Button;
import web.elements.TextField;

public class WidgetsPage {
    private final Button openWidgetsMenu = new Button("widgets menu", XmlReader.getAutoCompleteLocator("openWidgetsMenu"));
    private final Button openAutoCompletePage = new Button("auto complete page", XmlReader.getAutoCompleteLocator("openAutoCompletePage"));
    private final TextField multipleColorsField = new TextField("multiple colors", XmlReader.getAutoCompleteLocator("multipleColorsField"));
    private final TextField multipleColorsFieldAfter = new TextField("then", XmlReader.getAutoCompleteLocator("multipleColorsFieldAfter"));
    private final TextField autoCompletedMenu = new TextField("menu", XmlReader.getAutoCompleteLocator("autoCompletedMenu"));

    private final Button openDatePickerPage = new Button("page", XmlReader.getDatePickerLocator("openDatePickerPage"));
    private final TextField inputDateField = new TextField("date", XmlReader.getDatePickerLocator("inputDateField"));
    private final TextField inputDateAndTimeField = new TextField("date and time", XmlReader.getDatePickerLocator("inputDateAndTimeField"));
    private final Button monthPicker = new Button("month", XmlReader.getDatePickerLocator("monthPicker"));
    private final Button definedMonthPicker = new Button("month", XmlReader.getDatePickerLocator("definedMonthPicker"));
    private final Button yearPicker = new Button("year", XmlReader.getDatePickerLocator("yearPicker"));
    private final Button definedYearPicker = new Button("year", XmlReader.getDatePickerLocator("definedYearPicker"));
    private final Button definedDayPicker = new Button("day", XmlReader.getDatePickerLocator("definedDayPicker"));
    private final Button nextMonthPicker = new Button("month", XmlReader.getDatePickerLocator("nextMonthPicker"));
    private final Button nextYearPicker = new Button("year", XmlReader.getDatePickerLocator("nextYearPicker"));
    private final Button nextDefinedMonthPicker = new Button("month", XmlReader.getDatePickerLocator("nextDefinedMonthPicker"));
    private final Button nextDefinedYearPicker = new Button("year", XmlReader.getDatePickerLocator("nextDefinedYearPicker"));
    private final Button previousYearButton = new Button("year", XmlReader.getDatePickerLocator("previousYearButton"));
    private final Button nextDefinedDayPicker = new Button("day", XmlReader.getDatePickerLocator("nextDefinedDayPicker"));
    private final Button nextDefinedTimePicker = new Button("time", XmlReader.getDatePickerLocator("nextDefinedTimePicker"));

   private final Button openSliderPage = new Button("open", XmlReader.getSliderLocator("openSliderPage"));
   private final Button movingSlider = new Button("slider", XmlReader.getSliderLocator("movingSlider"));
   private final TextField sliderValueField = new TextField("value", XmlReader.getSliderLocator("sliderValueField"));

    public void goToAutoCompletePage() {
        openWidgetsMenu.waitForAppearance();
        openWidgetsMenu.scrollToElement();
        openWidgetsMenu.click();
        openAutoCompletePage.waitForAppearance();
        openAutoCompletePage.click();
        multipleColorsField.waitForClick();
    }

    public void typeMultipleColors(String color) {
        multipleColorsField.click();
        //doesnt work
        multipleColorsFieldAfter.sendKeys(color);
        autoCompletedMenu.waitForAppearance();
        autoCompletedMenu.click();
    }

    public void goToDatePickerPage() {
        openDatePickerPage.click();
        inputDateField.waitForAppearance();
    }

    public void enterFirstDate() {
        inputDateField.click();
        monthPicker.click();
        definedMonthPicker.click();

        yearPicker.click();
        definedYearPicker.click();

        definedDayPicker.click();
    }

    public String getFirstDate() {
        inputDateField.waitForAppearance();
        return inputDateField.getValue();
    }

    public void enterSecondDate() {
        inputDateAndTimeField.click();
        nextMonthPicker.waitForClick();
        nextMonthPicker.click();
        nextDefinedMonthPicker.waitForClick();
        nextDefinedMonthPicker.click();

        nextYearPicker.waitForClick();
        nextYearPicker.click();
        for (int i = 0; i < 20; i++) {
            //doesnt work
            previousYearButton.click();
        }
        nextDefinedYearPicker.click();

        nextDefinedDayPicker.waitForClick();
        nextDefinedDayPicker.click();
        nextDefinedTimePicker.waitForClick();
        nextDefinedTimePicker.click();
    }

    public String getSecondDate() {
        inputDateAndTimeField.waitForAppearance();
        return inputDateAndTimeField.getValue();
    }

    public void goToToolTipsPage() {
    }
}
