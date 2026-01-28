package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.widget.ScrollView;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class BaseModalWindow {

//    private BaseModalWindow() {
//    }

    private static final ViewInteraction modalWindow = onView(isAssignableFrom(ScrollView.class));
    private static final ViewInteraction modalWindowMsg = onView(withId(android.R.id.message));
    private static final ViewInteraction modalOkButton = onView(allOf(withId(android.R.id.button1),
            withText(R.string.fragment_positive_button)))
            .inRoot(isDialog());
    private static final ViewInteraction modalCancelButton = onView(
            allOf(withId(android.R.id.button2), withText(R.string.cancel)))
            .inRoot(isDialog());

    public static void tapOnOkButton() {
//        Allure.step("User taps on OK button");
        modalOkButton.perform(click());
    }

    public static void tapOnCancelButton() {
//        Allure.step("User taps on Cancel button");
        modalOkButton.perform(click());
    }

    public static void assertModalWindowIsDisplayed() {
//        Allure.step("Modal window is displayed");
        modalWindow.check(matches(isDisplayed()));
        modalOkButton.check(matches(isDisplayed()));
        modalCancelButton.check(matches(isDisplayed()));
    }

    public static void assertModalWindowMsgEqualsText(String text) {
//        Allure.step("Modal window msg is: " + text);
        modalWindowMsg.check(matches(withText(text)));
    }
}
