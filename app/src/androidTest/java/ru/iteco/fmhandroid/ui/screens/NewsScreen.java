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

import ru.iteco.fmhandroid.R;

public class NewsScreen {
    private NewsScreen() {
    }

    private static final int viewID = R.id.edit_news_material_button;
    private static final ViewInteraction newsScreenLabel = onView(allOf(
            withText(R.string.news),
            withParent(withParent(withId(R.id.container_list_news_include)))
    ));
    private static final ViewInteraction panelEditButton = onView(
            withId(R.id.edit_news_material_button));
    private static final ViewInteraction filterNewsButton = onView(
            withId(R.id.filter_news_material_button));
    private static final ViewInteraction sortNewsButton = onView(
            withId(R.id.sort_news_material_button));

    public static void assertIsOnScreen() {
        onView(withId(viewID)).check(matches(isDisplayed()));
    }

    public static void tapOnPanelEditButton() {
        panelEditButton.check(matches(isDisplayed()));
        panelEditButton.perform(click());
    }

    public static void tapOnFilterNewsButton() {
        filterNewsButton.perform(click());
    }

    public static void tapOnSortNewsButton() {
        sortNewsButton.perform(click());
    }

    public static void assertEditNewsButtonIsDisplayed() {
        panelEditButton.check(matches(isDisplayed()));
    }

    public static void assertFilterNewsButtonIsDisplayed() {
        filterNewsButton.check(matches(isDisplayed()));
    }

    public static void assertSortNewsButtonIsDisplayed() {
        sortNewsButton.check(matches(isDisplayed()));
    }

    public static void assertNewsScreenLabelIsDisplayed() {
        newsScreenLabel.check(matches(isDisplayed()));
    }
}
