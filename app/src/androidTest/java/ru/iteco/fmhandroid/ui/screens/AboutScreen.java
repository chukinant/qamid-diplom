package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.utils.ViewWaiterAndMatcher.waitUntilDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreen {

    private AboutScreen() {
    }

    private static final int versionLabelID = R.id.about_version_title_text_view;
    private static final ViewInteraction versionLabel = onView(withId(versionLabelID));
    private static final int versionLabelText = R.string.version;
    private static final int privacyPolicyLink = R.id.about_privacy_policy_value_text_view;
    private static final int termsOfUseLink = R.id.about_terms_of_use_value_text_view;

    public static void waitUntilIsDisplayed() {
        onView(isRoot()).perform(waitUntilDisplayed(versionLabelID, 5000));
    }

    public static void isOnScreen() {
        onView(withId(versionLabelID)).check(matches(isDisplayed()));
    }

    public static void assertVersionLabelIsDisplayed() {
        waitUntilIsDisplayed();
        versionLabel.check(matches(isDisplayed()));
        versionLabel.check(matches(withText(versionLabelText)));
    }

    public static void tapOnPrivacyPolicyLink() {
//        Allure.step("User taps on Privacy Policy link");
        onView(withId(privacyPolicyLink)).check(matches(isDisplayed()));
        onView(withId(privacyPolicyLink)).perform(click());
    }

    public static void tapOnTermsOfUseLink() {
//        Allure.step("User taps on Terms of Use link");
        onView(withId(termsOfUseLink)).check(matches(isDisplayed()));
        onView(withId(termsOfUseLink)).perform(click());
    }
}
