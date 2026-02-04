package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.AboutScreen;

public class AboutScreenSteps {

    public void assertVersionLabelIsDisplayed() {
        Allure.step("User is redirected to About screen");
        AboutScreen.assertVersionLabelIsDisplayed();
    }

    public void tapOnPrivacyPolicyLink() {
        Allure.step("User taps on Privacy Policy link");
        AboutScreen.tapOnPrivacyPolicyLink();
    }

    public void tapOnTermsOfUseLink() {
        Allure.step("User taps on Terms of Use link");
        AboutScreen.tapOnTermsOfUseLink();
    }
}