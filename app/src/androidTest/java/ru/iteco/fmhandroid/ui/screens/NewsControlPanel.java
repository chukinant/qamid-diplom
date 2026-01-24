package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.widget.LinearLayout;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class NewsControlPanel {

    private NewsControlPanel() {}

    private static final int viewID = R.id.edit_news_material_button;
    private static final ViewInteraction newsControlPanelLabel = onView(allOf(
            withText("Control panel"),
            withParent(withParent(IsInstanceOf.<View>instanceOf(LinearLayout.class)))
    )).check(matches(isDisplayed()));

    private static final ViewInteraction addNewsButton = onView(allOf(
            withId(R.id.add_news_image_view), withContentDescription("Add news button")));
    private static final ViewInteraction filterNewsButton = onView(
            withId(R.id.filter_news_material_button));
    private static final ViewInteraction sortNewsButton = onView(
            withId(R.id.sort_news_material_button));

    public static void assertIsOnScreen() {
        onView(withId(viewID)).check(matches(isDisplayed()));
    }

    public static void tapOnAddNewsButton() {
        addNewsButton.perform(click());
    }
//
//    public static void tapOnFilterNewsButton() {
//        filterNewsButton.perform(click());
//    }
//
//    public static void tapOnSortNewsButton() {
//        sortNewsButton.perform(click());
//    }
//
//    public static void assertEditNewsButtonIsDisplayed () {
//        editNewsButton.check(matches(isDisplayed()));
//    }
//
//    public static void assertFilterNewsButtonIsDisplayed () {
//        filterNewsButton.check(matches(isDisplayed()));
//    }
//
//    public static void assertSortNewsButtonIsDisplayed () {
//        sortNewsButton.check(matches(isDisplayed()));
//    }
//
    public static void assertNewsControlPanelLabelIsDisplayed () {
        newsControlPanelLabel.check(matches(isDisplayed()));
    }
}
