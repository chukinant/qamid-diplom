package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.ViewWaiterAndMatcher.waitUntilDisplayed;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainScreen {

    private MainScreen() {}

    private static final int viewID = R.id.container_list_news_include_on_fragment_main;
    private static final ViewInteraction allNewsLink = onView(withId(R.id.all_news_text_view));
    private static final int allNewsLinkText = R.string.all_news;

    public static void waitUntilIsDisplayed () {
        onView(isRoot()).perform(waitUntilDisplayed(viewID, 5000));
    }

    public static void assertIsOnScreen() {
            onView(withId(viewID)).check(matches(isDisplayed()));
        }

    public static int getRootViewId() {
        return viewID;
    }

    public static void tapOnAllNewsLink() {
//        Allure.step("User taps on the " + allNewsLinkText + " link");
        allNewsLink.perform(click());
    }

    public static void assertAllNewsLinkIsDisplayed () {
        waitUntilIsDisplayed();
        allNewsLink.check(matches(isDisplayed()));
        allNewsLink.check(matches(withText(allNewsLinkText)));
    }
}
