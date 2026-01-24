package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.NewsControlPanel;
import ru.iteco.fmhandroid.ui.screens.NewsScreen;

public class NewsControlPanelSteps {

    public void tapOnAddNewsButton() {
        Allure.step("User taps on Add news button");
        NewsControlPanel.tapOnAddNewsButton();
    }

    public void assertNewsControlPanelLabelIsDisplayed() {
        Allure.step("News control panel label is displayed");
        NewsControlPanel.assertNewsControlPanelLabelIsDisplayed();
    }
}
