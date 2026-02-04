package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.OurMissionCard;
import ru.iteco.fmhandroid.ui.screens.OurMissionScreen;

public class OurMissionScreenSteps {

    public void assertTitleIsDisplayed() {
        Allure.step("User is redirected on Our Mission screen");
        OurMissionScreen.assertTitleIsDisplayed();
    }

    public void tapOnCard(int position) {
        Allure.step("User taps on card at position: " + position);
        OurMissionCard.scrollTo(position);
        OurMissionCard.expand(position);
    }

    public void assertCardHasDescription(int position) {
        Allure.step("Card at position: " + position + " has description");
        OurMissionCard.assertHasDescription(position);
    }

}
