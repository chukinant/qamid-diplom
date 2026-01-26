package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.BaseNewsDialog;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public abstract class BaseNewsDialogSteps {

    protected final DatePickerDialogSteps datePickerDialog = new DatePickerDialogSteps();
    protected final TimePickerDialogSteps timePickerDialog = new TimePickerDialogSteps();


    public void assertIsOnScreen() {
        Allure.step("Creating/Editing News dialog is displayed");
        BaseNewsDialog.assertIsOnScreen();
    }

    public void assertFieldsAreDisplayed() {
        Allure.step("Category, Title, Publication date, Time, Description fields are displayed");
        BaseNewsDialog.assertFieldsAreDisplayed();
    }

    public void tapOnCategoryField() {
        Allure.step("User taps on the Category field");
        BaseNewsDialog.tapOnCategoryField();
    }

    public void tapOnCategoryItemOnTheList(int pos) {
        Allure.step("User taps on the {pos}th item on the dropdown list");
        BaseNewsDialog.tapOnCategoryItemOnTheList(pos);
    }

    public void tapOnTimeField() {
        Allure.step("User taps on publication time field");
        BaseNewsDialog.tapOnTimeField();
    }

    public void tapOnDateField() {
        Allure.step("User taps on publication date field");
        BaseNewsDialog.tapOnDateField();
    }

    public void assignDate(int daysAhead) {
        Allure.step("User assigns date of " + daysAhead + " days ahead");
        datePickerDialog.assignDate(daysAhead);
    }

    public void assignTime(int hour, int minute) {
        Allure.step("User assigns time of " + hour + " hours and " + minute + " minutes");
        timePickerDialog.assignTime(hour, minute);
    }

    public void addDescription(String description) {
        Allure.step("User adds news description");
        BaseNewsDialog.addDescription(description);
    }

    public void tapOnSaveButton() {
        Allure.step("User taps on Save button");
        BaseNewsDialog.tapOnSaveButton();
    }

    public void tapOnCancelButton() {
        Allure.step("User taps on Cancel button");
        BaseNewsDialog.tapOnCancelButton();
    }

    public void specifyNewsTitle(String title) {
        Allure.step("User specifies news title");
        BaseNewsDialog.specifyNewsTitle(title);
    }

    public static void assertCategory(String category) {
      Allure.step("Assert chosen category");
        BaseNewsDialog.assertCategory(category);
    }

    public void assertPublicationDate(String date) {
      Allure.step("Publication date field is filled with the chosen date");
        BaseNewsDialog.assertPublicationDate(date);
    }

    public void assertPublicationTime(String time) {
      Allure.step("Publication date field is filled with the chosen date");
        BaseNewsDialog.assertPublicationTime(time);
    }

    public void assertFillEmptyFieldsMsgIsDisplayed(View decorView) {
        Allure.step("Toast msg that with text " + R.string.empty_fields + " is displayed");
        BaseNewsDialog.assertFillEmptyFieldsMsgIsDisplayed(decorView);
    }
}
