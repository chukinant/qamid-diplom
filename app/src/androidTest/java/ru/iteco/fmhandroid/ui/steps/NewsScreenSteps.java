package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.NewsScreen;

public class NewsScreenSteps extends BaseScreenSteps {

    public void tapOnPanelEditButton() {
        Allure.step("User taps on Edit News button");
        NewsScreen.tapOnPanelEditButton();
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

