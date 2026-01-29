package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.ControlPanelNewsCard;
import ru.iteco.fmhandroid.ui.screens.NewsControlPanel;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class NewsControlPanelSteps {

    public void tapOnAddNewsButton() {
        Allure.step("User taps on Add news button");
        NewsControlPanel.tapOnAddNewsButton();
    }

    public void tapOnEditNewsCardButton(NewsItemInfo info) {
        Allure.step("User taps on Edit news card button");
        ControlPanelNewsCard.tapOnEditButton(info);
    }

    public static void tapOnFilterNewsButton() {
        Allure.step("User taps on Filter News Button");
        NewsControlPanel.tapOnFilterNewsButton();
    }

    public static void tapOnSortNewsButton() {
        Allure.step("User taps on Sort News Button");
        NewsControlPanel.tapOnSortNewsButton();
    }

    public static void assertFilterNewsButtonIsDisplayed () {
        Allure.step("Filter News Button is displayed");
        NewsControlPanel.assertFilterNewsButtonIsDisplayed();
    }

    public static void assertSortNewsButtonIsDisplayed () {
        Allure.step("Sort News Button is displayed");
        NewsControlPanel.assertSortNewsButtonIsDisplayed();
    }

    public void assertNewsControlPanelLabelIsDisplayed() {
        Allure.step("News control panel label is displayed");
        NewsControlPanel.assertNewsControlPanelLabelIsDisplayed();
    }

    public void assertNewsCardInfo(NewsItemInfo info) {
        Allure.step("Scroll to news card");
        ControlPanelNewsCard.scrollTo(info.getTitle());
        Allure.step("Assert news card title");
        ControlPanelNewsCard.assertTitle(info);
        Allure.step("Assert news card publication date");
        ControlPanelNewsCard.assertPublicationDate(info);
//        Allure.step("Assert news card creation date");
//        ControlPanelNewsCard.assertCreationDate(info);
        Allure.step("Assert news card status");
        ControlPanelNewsCard.assertStatus(info);
        Allure.step("Assert news card description");
        ControlPanelNewsCard.expand(info.getTitle());
        ControlPanelNewsCard.scrollExpandedIntoView(info.getTitle());
        ControlPanelNewsCard.assertDescription(info);
    }

    public void assertCardIsNotOnTheList(NewsItemInfo info) {
        Allure.step("Assert card is not on the list");
        ControlPanelNewsCard.assertNotOnTheList(info.getTitle());
    }
}
