package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.utils.ViewWaiterAndMatcher.waitUntilDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NavigationBar {

    private NavigationBar() {
    }

    private static final int waitingForID = R.id.main_menu_image_button;
    private static final ViewInteraction hamburgerButton = onView(allOf(
            withId(R.id.main_menu_image_button),
            withContentDescription("Main menu")));

    private static final ViewInteraction ourMissionButton = onView(allOf(
            withId(R.id.main_menu_image_button),
            withContentDescription("Our Mission")));

    private static final ViewInteraction profileButton = onView(
            withId(R.id.authorization_image_button));

    private static final ViewInteraction navigationDrawerButtonMain = onView(allOf(
            withId(android.R.id.title), withText(R.string.main)));

    private static final ViewInteraction navigationDrawerButtonNews = onView(allOf(
            withId(android.R.id.title), withText(R.string.news)));

    private static final ViewInteraction navigationDrawerButtonAbout = onView(allOf(
            withId(android.R.id.title), withText(R.string.about)));

    private static final ViewInteraction profileButtonLogout = onView(allOf(
            withId(android.R.id.title), withText(R.string.log_out)));

    public static void logout() {
        profileButton.check(matches(isDisplayed()));
        profileButton.perform(click());
        profileButtonLogout.check(matches(isDisplayed()));
        profileButtonLogout.perform(click());
    }

    public static void assertIsOnScreen() {
        onView(isRoot()).perform(waitUntilDisplayed(waitingForID, 5000));
        onView(withId(waitingForID)).check(matches(isDisplayed()));
    }

    public static void tapOnNavigationDrawer() {
        hamburgerButton.perform(click());
    }

    public static void tapOnMainButton() {
        navigationDrawerButtonMain.perform(click());
    }

    public static void tapOnNewsButton() {
        navigationDrawerButtonNews.perform(click());
    }

    public static void tapOnAboutButton() {
        navigationDrawerButtonAbout.perform(click());
    }

    public static void tapOnOurMissionButton() {
        ourMissionButton.perform(click());
    }

    public static void tapOnProfileButton() {
        profileButton.perform(click());
    }

    public static void tapLogoutButton() {
        profileButtonLogout.perform(click());
    }

    public static void assertHamburgerButtonIsDisplayed() {
        hamburgerButton.check(matches(isDisplayed()));
    }

    public static void assertOurMissionButtonIsDisplayed() {
        ourMissionButton.check(matches(isDisplayed()));
    }

    public static void assertProfileButtonIsDisplayed() {
        profileButton.check(matches(isDisplayed()));
    }

    public static void assertNavigationDrawerButtonMainIsDisplayed() {
        navigationDrawerButtonMain.check(matches(isDisplayed()));
    }

    public static void assertNavigationDrawerButtonNewsIsDisplayed() {
        navigationDrawerButtonNews.check(matches(isDisplayed()));
    }

    public static void assertNavigationDrawerButtonAboutIsDisplayed() {
        navigationDrawerButtonAbout.check(matches(isDisplayed()));
    }

    public static void assertProfileButtonLogoutIsDisplayed() {
        profileButtonLogout.check(matches(isDisplayed()));
    }
}
