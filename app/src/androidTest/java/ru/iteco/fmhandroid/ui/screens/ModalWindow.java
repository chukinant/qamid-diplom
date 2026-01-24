package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class ModalWindow {

    private static final ViewInteraction modalWindowID = onView(withId(com.google.android.material.R.id.scrollView));
    private static final ViewInteraction modalWindowMsg = onView(withId(android.R.id.message));
    private static final ViewInteraction modalOkButton = onView(
            allOf(withId(android.R.id.button1), withText(R.string.fragment_positive_button)));
    private static final ViewInteraction modalCancelButton = onView(
            allOf(withId(android.R.id.button1), withText(R.string.cancel)));

    public void tapOnOkButton() {
        Allure.step("User taps on OK button");
        modalOkButton.perform(click());
    }

    public void tapOnCancelButton() {
        Allure.step("User taps on Cancel button");
        modalOkButton.perform(click());
    }

    public void assertModalWindowIsDisplayed() {
        Allure.step("Modal window is displayed");
        modalWindowID.check(matches(isDisplayed()));
        modalOkButton.check(matches(isDisplayed()));
        modalCancelButton.check(matches(isDisplayed()));
    }

    public void assertModalWindowMsgEqualsText(String text) {
        Allure.step("Modal window msg is {text}");
        modalWindowMsg.check(matches(withText(text)));
    }
}
