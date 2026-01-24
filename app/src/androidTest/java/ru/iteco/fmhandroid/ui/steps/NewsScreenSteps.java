package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import static ru.iteco.fmhandroid.ui.screens.NewsScreen.*;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.NewsScreen;

public class NewsScreenSteps {

    public void tapOnEditNewsButton() {
        Allure.step("User taps on Edit News button");
        NewsScreen.tapOnEditNewsButton();
    }

    public void tapOnFilterNewsButton() {
        Allure.step("User taps on Filter News button");
        NewsScreen.tapOnFilterNewsButton();
    }

    public void tapOnSortNewsButton() {
        Allure.step("User taps on Sort News button");
        NewsScreen.tapOnSortNewsButton();
    }

    public void assertNewsScreenLabelIsDisplayed() {
        Allure.step("News screen label is displayed");
        NewsScreen.assertNewsScreenLabelIsDisplayed();
    }

    public void assertEditNewsButtonIsDisplayed() {
        Allure.step("Edit News button is displayed");
        NewsScreen.assertEditNewsButtonIsDisplayed();
    }

    public void assertFilterNewsButtonIsDisplayed() {
        Allure.step("Filter News button is displayed");
        NewsScreen.assertFilterNewsButtonIsDisplayed();
    }

    public void assertSortNewsButtonIsDisplayed() {
        Allure.step("Sort News button is displayed");
        NewsScreen.assertSortNewsButtonIsDisplayed();
    }
}

