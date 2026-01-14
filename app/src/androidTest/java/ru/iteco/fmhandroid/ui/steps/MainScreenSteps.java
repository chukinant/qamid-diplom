package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.MainScreen;

public class MainScreenSteps {

    @Step("User is redirected to Main screen")
    public void assertAllNewsLinkIsDisplayed() {
        MainScreen.assertAllNewsLinkIsDisplayed();
    }

}
