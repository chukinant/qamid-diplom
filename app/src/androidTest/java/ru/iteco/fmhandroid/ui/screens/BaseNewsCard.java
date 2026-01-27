package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.contrib.RecyclerViewActions;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class BaseNewsCard {

    protected static Matcher<View> cardWithTitle(String title) {
        return allOf(
                withId(R.id.news_item_material_card_view),
                hasDescendant(allOf(
                        withId(R.id.news_item_title_text_view),
                        withText(title))));
    }

    public static void scrollTo(String title) {
        onView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.scrollTo(
                        cardWithTitle(title)));
    }

    public static void expand(String title) {
        onView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.actionOnItem(
                        cardWithTitle(title),
                        click()));
    }

    public static void scrollExpandedIntoView(String title) {
        onView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.scrollTo(
                        cardWithTitle(title)));
    }

    public static void assertTitle(NewsItemInfo info) {
        onView(cardWithTitle(info.getTitle()))
                .check(matches(hasDescendant(allOf(
                        withId(R.id.news_item_title_text_view),
                        withText(info.getTitle())))));
    }

    public static void assertDescription(NewsItemInfo info) {
        onView(cardWithTitle(info.getTitle()))
                .check(matches(hasDescendant(allOf(
                        withId(R.id.news_item_description_text_view),
                        withText(info.getDescription()),
                        isDisplayed()))));
    }
}
