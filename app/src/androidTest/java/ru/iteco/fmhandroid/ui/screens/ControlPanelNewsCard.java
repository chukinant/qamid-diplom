package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class ControlPanelNewsCard extends BaseNewsCard {

    public static void assertPublicationDate(NewsItemInfo info) {
        onView(cardWithTitle(info.getTitle()))
                .check(matches(hasDescendant(allOf(
                        withId(R.id.news_item_publication_date_text_view),
                        withText(info.getPublicationDate())))));
    }

    public static void assertCreationDate(NewsItemInfo info) {
        onView(cardWithTitle(info.getTitle()))
                .check(matches(hasDescendant(allOf(
                        withId(R.id.news_item_create_date_text_view),
                        withText(info.getCreationDate())))));
    }

    public static void assertStatus(NewsItemInfo info) {
        onView(cardWithTitle(info.getTitle()))
                .check(matches(hasDescendant(allOf(
                        withId(R.id.news_item_published_text_view),
                        withText(info.getStatus())))));
    }
}
