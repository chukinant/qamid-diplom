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

    public void assertNewsControlPanelLabelIsDisplayed() {
        Allure.step("News control panel label is displayed");
        NewsControlPanel.assertNewsControlPanelLabelIsDisplayed();
    }

    public void assertNewsCardInfo(NewsItemInfo info) {
        Allure.step("Scroll to created news card");
        ControlPanelNewsCard.scrollTo(info.getTitle());
        Allure.step("Assert created news card title");
        ControlPanelNewsCard.assertTitle(info);
        Allure.step("Assert created news card publication date");
        ControlPanelNewsCard.assertPublicationDate(info);
//        Allure.step("Assert created news card creation date");
//        ControlPanelNewsCard.assertCreationDate(info);
        Allure.step("Assert created news card status");
        ControlPanelNewsCard.assertStatus(info);
        Allure.step("Assert created news card description");
        ControlPanelNewsCard.expand(info.getTitle());
        ControlPanelNewsCard.scrollExpandedIntoView(info.getTitle());
        ControlPanelNewsCard.assertDescription(info);
    }
}
