package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.ViewWaiterAndMatcher.waitUntilDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OurMissionScreen {

    private OurMissionScreen() {
    }

    private static final int titleID = R.id.our_mission_title_text_view;
    private static final int titleText = R.string.our_mission_title_text;

    public static void waitUntilIsDisplayed() {
        onView(isRoot()).perform(waitUntilDisplayed(titleID, 5000));
    }

    public static void assertTitleIsDisplayed() {
//        Allure.step("User is redirected on Our Mission screen");
        waitUntilIsDisplayed();
        onView(withId(titleID)).check(matches(isDisplayed()));
        onView(withId(titleID)).check(matches(withText(titleText)));
    }



}
