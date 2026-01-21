package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.MainScreen;

public class MainScreenSteps {

    public void assertAllNewsLinkIsDisplayed() {
        Allure.step("User is redirected to Main screen");
        MainScreen.assertAllNewsLinkIsDisplayed();
    }

}
