package ru.iteco.fmhandroid.ui.steps;

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
