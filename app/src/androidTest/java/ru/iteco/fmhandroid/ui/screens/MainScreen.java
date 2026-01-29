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

public class MainScreen {

    private MainScreen() {
    }

    private static final int waitingForID = R.id.container_list_news_include_on_fragment_main;
    private static final ViewInteraction allNewsLink = onView(withId(R.id.all_news_text_view));
    private static final int allNewsLinkText = R.string.all_news;

    public static void waitUntilIsDisplayed() {
        onView(isRoot()).perform(waitUntilDisplayed(waitingForID, 5000));
    }

    public static void assertIsOnScreen() {
        onView(withId(waitingForID)).check(matches(isDisplayed()));
    }

    public static void tapOnAllNewsLink() {
//        Allure.step("User taps on the " + allNewsLinkText + " link");
        allNewsLink.perform(click());
    }

    public static void assertAllNewsLinkIsDisplayed() {
        waitUntilDisplayed(R.id.all_news_text_view,5000);
        allNewsLink.check(matches(isDisplayed()));
        allNewsLink.check(matches(withText(allNewsLinkText)));
    }
}
