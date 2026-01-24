package ru.iteco.fmhandroid.ui.steps;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.CreatingNewsDialog;

public abstract class BaseNewsDialogSteps {

    public void assertIsOnScreen() {
        Allure.step("Creating News dialog is displayed");
        CreatingNewsDialog.assertIsOnScreen();
    }

    public void tapOnCategoryField() {
        Allure.step("User taps on the Category field");
        CreatingNewsDialog.tapOnCategoryField();
    }

    public void tapOnCategoryItemOnTheList(int position) {
        Allure.step("User taps on the {int}th item on the dropdown list");
        CreatingNewsDialog.tapOnCategoryItemOnTheList(position);
    }

    public void tapOnSaveButton() {
        Allure.step("User taps on Save button");
        CreatingNewsDialog.tapOnSaveButton();
    }

    public void assertFillEmptyFieldsMsgIsDisplayed(View decorView) {
        Allure.step("Toast msg that with text " + R.string.empty_fields + " is displayed");
        CreatingNewsDialog.assertFillEmptyFieldsMsgIsDisplayed(decorView);
    }
}
