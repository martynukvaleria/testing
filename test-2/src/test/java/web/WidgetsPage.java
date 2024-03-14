package web;

import core.XmlReader;
import web.elements.Button;
import web.elements.Slider;
import web.elements.TextField;

import static org.testng.Assert.assertEquals;

public class WidgetsPage {
    //colors
    private final Button openWidgetsMenu = new Button("widgets menu", XmlReader.getAutoCompleteLocator("openWidgetsMenu"));
    private final Button openAutoCompletePage = new Button("auto complete page", XmlReader.getAutoCompleteLocator("openAutoCompletePage"));
    private final TextField multipleColorsField = new TextField("multiple colors", XmlReader.getAutoCompleteLocator("multipleColorsField"));
    private final TextField result= new TextField("result", XmlReader.getAutoCompleteLocator("result"));

    //date picker
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
    //slider
    private final Button openSliderPage = new Button("open", XmlReader.getSliderLocator("openSliderPage"));
    private final Slider movingSlider = new Slider("slider", XmlReader.getSliderLocator("movingSlider"));
    private final TextField sliderValueField = new TextField("value", XmlReader.getSliderLocator("sliderValueField"));
    //tool tips
    private final Button openToolTipsPage = new Button("open", XmlReader.getToolTipsLocator("openToolTipsPage"));
    private final TextField reference = new TextField("reference", XmlReader.getToolTipsLocator("reference"));
    private final TextField referenceAfter = new TextField("reference", XmlReader.getToolTipsLocator("referenceAfter"));

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
        multipleColorsField.sendKeys(color);
        multipleColorsField.clickEnter();
    }

    public String result() {
        return result.returnResultColors();
    }

    public void goToDatePickerPage() {
        openDatePickerPage.scrollToElement();
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
        inputDateAndTimeField.scrollToElement();
        inputDateAndTimeField.click();
        nextMonthPicker.waitForClick();
        nextMonthPicker.click();
        nextDefinedMonthPicker.waitForClick();
        nextDefinedMonthPicker.click();

        nextYearPicker.waitForClick();
        nextYearPicker.click();

        while (!nextDefinedYearPicker.isVisible()) {
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
        inputDateAndTimeField.scrollToElement();
        return inputDateAndTimeField.getValue();
    }

    public void goToSliderPage() {
        openSliderPage.scrollToElement();
        openSliderPage.click();
        sliderValueField.waitForAppearance();
    }

    public void moveSliderToRight(int value) {
        movingSlider.moveToRight(value);
    }

    public void moveSliderToLeft(int value) {
        movingSlider.moveToLeft(value);
    }

    public String getMoveResult() {
        return sliderValueField.getValue();
    }

    public void goToToolTipsPage() {
        openToolTipsPage.scrollToElement();
        openToolTipsPage.click();
        reference.waitForAppearance();
        reference.scrollToElement();
    }

    public void checkHoverToText() {
        reference.hover();
        referenceAfter.waitForAppearance();
    }
}
