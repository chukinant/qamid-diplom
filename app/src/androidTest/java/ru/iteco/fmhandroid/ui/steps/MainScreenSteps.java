package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.MainScreen;

public class MainScreenSteps {

    public void tapOnAllNewsLink() {
        Allure.step("User taps on the All News link");
        MainScreen.tapOnAllNewsLink();
    }


    public void assertAllNewsLinkIsDisplayed() {
        Allure.step("User is redirected to Main screen");
        MainScreen.assertAllNewsLinkIsDisplayed();
    }
}
