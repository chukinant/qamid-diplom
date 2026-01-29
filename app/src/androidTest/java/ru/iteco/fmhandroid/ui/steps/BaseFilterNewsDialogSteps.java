package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.BaseFilterNewsDialog;

public class BaseFilterNewsDialogSteps {

    public void assertIsOnScreen() {
//        Allure.step("Filter News dialog is displayed");
        BaseFilterNewsDialog.assertIsOnScreen();
    }

    public void assertElementsAreDisplayed() {
        Allure.step("Fields and buttons are displayed");
        BaseFilterNewsDialog.assertElementsAreDisplayed();
    }

    public void tapOnCategoryItemOnTheList(int pos) {
        Allure.step("User taps on the " + (pos + 1) + "th item on the dropdown list");
        BaseFilterNewsDialog.tapOnCategoryItemOnTheList(pos);
    }

    public void tapOnStartPubDateField() {
        Allure.step("User taps on starting publication date field");
        BaseFilterNewsDialog.tapOnStartPubDateField();
    }

    public void tapOnEndPubDateField() {
        Allure.step("User taps on starting publication date field");
        BaseFilterNewsDialog.tapOnEndPubDateField();
    }

    public void tapOnCancelButton() {
        Allure.step("User taps on Cancel button");
        BaseFilterNewsDialog.tapOnCancelButton();
    }

    public void tapOnFilterButton() {
        Allure.step("User taps on Filter button");
        BaseFilterNewsDialog.tapOnFilterButton();
    }

    public void assertFilterNewsDialogTitleIsDisplayed() {
        Allure.step("Filter News dialog title is displayed");
        BaseFilterNewsDialog.assertFilterNewsDialogTitleIsDisplayed();
    }

    public void assertStartPubDate(String date) {
        Allure.step("Assert chosen starting publication date");
        BaseFilterNewsDialog.assertStartPubDate(date);
    }

    public void assertEndPubDate(String date) {
        Allure.step("Assert chosen ending publication date");
        BaseFilterNewsDialog.assertEndPubDate(date);
    }
}
