package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.NewsScreenNewsCard;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class BaseScreenSteps {

    public void assertNewsCardInfo(NewsItemInfo info) {
        Allure.step("Scroll to news card");
        NewsScreenNewsCard.scrollTo(info.getTitle());
        Allure.step("Assert news card title");
        NewsScreenNewsCard.assertTitle(info);
        Allure.step("Assert news card date");
        NewsScreenNewsCard.assertDate(info);
        Allure.step("Assert news card description");
        NewsScreenNewsCard.expand(info.getTitle());
        NewsScreenNewsCard.scrollExpandedIntoView(info.getTitle());
        NewsScreenNewsCard.assertDescription(info);
    }

    public void assertCardIsNotOnTheList(NewsItemInfo info) {
        Allure.step("Assert card is not on the list");
        NewsScreenNewsCard.assertNotOnTheList(info.getTitle());
    }
}
