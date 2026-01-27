package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.AboutScreen;

public class AboutScreenSteps {

    public void assertVersionLabelIsDisplayed() {
        Allure.step("User is redirected to About screen");
//        AboutScreen.waitUntilIsDisplayed();
        AboutScreen.assertVersionLabelIsDisplayed();
    }
}
