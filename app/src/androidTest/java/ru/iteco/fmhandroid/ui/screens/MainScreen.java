package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.auxiliaries.ViewWaiterAndMatcher.waitUntilDisplayed;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainScreen {

    private MainScreen() {}

    private static final int viewID = R.id.all_news_text_view;
    private static final ViewInteraction textView = onView(withId(R.id.all_news_text_view));
    private static final String allNewsLink = "ALL NEWS";

    public static void waitUntilIsDisplayed () {
        onView(isRoot()).perform(waitUntilDisplayed(viewID, 5000));
    }

    public static void assertAllNewsLinkIsDisplayed () {
        waitUntilIsDisplayed();
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText(allNewsLink)));
    }
}
