package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NavigationBar {

    private NavigationBar() {}

    private static final int viewID = R.id.nav_host_fragment;
    public static final ViewInteraction hamburgerButton = onView(allOf(
            withId(R.id.main_menu_image_button),
            withContentDescription("Main menu")));

    public static final ViewInteraction ourMissionButton = onView(allOf(
            withId(R.id.main_menu_image_button),
            withContentDescription("Our Mission")));

    public static final ViewInteraction profileButton = onView(
            withId(R.id.authorization_image_button));

    public static final ViewInteraction navigationDrawerButtonMain = onView(allOf(
            withId(android.R.id.title), withText("Main")));

    public static final ViewInteraction navigationDrawerButtonNews = onView(allOf(
            withId(android.R.id.title), withText("News")));

    public static final ViewInteraction navigationDrawerButtonAbout = onView(allOf(
            withId(android.R.id.title), withText("About")));

    public static final ViewInteraction profileButtonLogout = onView(allOf(
            withId(android.R.id.title), withText("Log out")));

    public static void logout () {
        profileButton.check(matches(isDisplayed()));
        profileButton.perform(click());
        profileButtonLogout.check(matches(isDisplayed()));
        profileButtonLogout.perform(click());
    }
}
