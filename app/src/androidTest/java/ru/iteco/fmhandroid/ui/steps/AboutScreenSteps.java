package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.AboutScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;

public class AboutScreenSteps {

    @Step("User is redirected to About screen")
    public void assertVersionLabelIsDisplayed() {
        AboutScreen.assertVersionLabelIsDisplayed();
    }
}
