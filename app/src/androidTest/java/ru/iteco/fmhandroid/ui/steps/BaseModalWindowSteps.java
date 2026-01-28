package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.BaseModalWindow;

public class BaseModalWindowSteps {

    public void tapOnOkButton() {
        Allure.step("User taps on OK button");
        BaseModalWindow.tapOnOkButton();
    }

    public void tapOnCancelButton() {
        Allure.step("User taps on Cancel button");
        BaseModalWindow.tapOnCancelButton();
    }

    public void assertModalWindowIsDisplayed() {
        Allure.step("Modal window is displayed");
        BaseModalWindow.assertModalWindowIsDisplayed();
    }
}
