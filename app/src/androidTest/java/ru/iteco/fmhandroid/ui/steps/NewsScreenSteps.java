package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.ControlPanelNewsCard;
import ru.iteco.fmhandroid.ui.screens.NewsScreen;
import ru.iteco.fmhandroid.ui.screens.NewsScreenNewsCard;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

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

    public void assertNewsCardInfo(NewsItemInfo info) {
        Allure.step("Scroll to created news card");
        NewsScreenNewsCard.scrollTo(info.getTitle());
        Allure.step("Assert created news card title");
        NewsScreenNewsCard.assertTitle(info);
        Allure.step("Assert created news card date");
        NewsScreenNewsCard.assertDate(info);
        Allure.step("Assert created news card description");
        NewsScreenNewsCard.expand(info.getTitle());
        NewsScreenNewsCard.scrollExpandedIntoView(info.getTitle());
        NewsScreenNewsCard.assertDescription(info);
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

