package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.NewsScreenNewsCard;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class MainScreenSteps {

    public void tapOnAllNewsLink() {
        Allure.step("User taps on the All News link");
        MainScreen.tapOnAllNewsLink();
    }

    public void assertAllNewsLinkIsDisplayed() {
        Allure.step("User is redirected to Main screen");
        MainScreen.assertAllNewsLinkIsDisplayed();
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
}
