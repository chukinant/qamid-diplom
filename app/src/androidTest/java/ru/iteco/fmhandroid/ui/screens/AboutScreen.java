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

public class AboutScreen {

    private AboutScreen() {}

    private final static int versionLabelID = R.id.about_version_title_text_view;
    private final static ViewInteraction versionLabel = onView(withId(versionLabelID));

    private final static String versionLabelText = "Version:";


    public static void waitUntilIsDisplayed () {
        onView(isRoot()).perform(waitUntilDisplayed(versionLabelID, 5000));
    }

    public static boolean isOnScreen() {
        onView(withId(versionLabelID)).check(matches(isDisplayed()));
        return true;
    }
    public static void assertVersionLabelIsDisplayed () {
        waitUntilIsDisplayed();
        versionLabel.check(matches(isDisplayed()));
        versionLabel.check(matches(withText(versionLabelText)));
    }
}
