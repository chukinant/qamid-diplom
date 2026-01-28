package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.MainScreen;

public class MainScreenSteps extends BaseScreenSteps {

    public void tapOnAllNewsLink() {
        Allure.step("User taps on the All News link");
        MainScreen.tapOnAllNewsLink();
    }

    public void assertAllNewsLinkIsDisplayed() {
        Allure.step("User is redirected to Main screen");
        MainScreen.assertAllNewsLinkIsDisplayed();
    }
}
