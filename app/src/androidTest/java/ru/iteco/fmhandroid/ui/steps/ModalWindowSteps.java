package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.ModalWindow;

public class ModalWindowSteps {

    public void tapOnOkButton() {
        Allure.step("User taps on OK button");
        ModalWindow.tapOnOkButton();
    }

    public void tapOnCancelButton() {
        Allure.step("User taps on Cancel button");
        ModalWindow.tapOnCancelButton();
    }

    public void assertModalWindowIsDisplayed() {
        Allure.step("Modal window is displayed");
        ModalWindow.assertModalWindowIsDisplayed();
    }

    public void assertModalWindowMsgEqualsText(String text) {
        Allure.step("Modal window msg is: " + text);
        ModalWindow.assertModalWindowMsgEqualsText(text);
    }
}
