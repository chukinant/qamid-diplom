package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class ControlPanelNewsCard extends BaseNewsCard {

//    protected static ViewInteraction editButton = onView(withId(R.id.edit_news_item_image_view));
//    protected static ViewInteraction deleteButton = onView(withId(R.id.delete_news_item_image_view));

    public static void tapOnDeleteButton(NewsItemInfo info) {
//        Allure.step("User taps on Delete button");
        scrollTo(info.getTitle());
        onView(allOf(
                withId(R.id.delete_news_item_image_view),
                isDescendantOfA(cardWithTitle(info.getTitle()))
        )).perform(click());
    }

    public static void tapOnEditButton(NewsItemInfo info) {
//        Allure.step("User taps on Edit button");
        scrollTo(info.getTitle());
        onView(allOf(
                withId(R.id.edit_news_item_image_view),
                isDescendantOfA(cardWithTitle(info.getTitle()))
        )).perform(click());
    }

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
