package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AppActivityTest3 {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void appActivityTest3() {
        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.all_news_text_view), withText("All news"),
                        childAtPosition(
                                allOf(withId(R.id.container_list_news_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withId(R.id.all_news_cards_block_constraint_layout),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("Новость: 1769540301662"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView.check(matches(withText("Новость: 1769540301662")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.news_item_description_text_view), withText("Описание новости: 1769540301662"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView2.check(matches(withText("Описание новости: 1769540301662")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.news_item_date_text_view), withText("27.01.2026"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView3.check(matches(withText("27.01.2026")));


//        Control panel



        ViewInteraction materialButton = onView(
                allOf(withId(R.id.edit_news_material_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.container_list_news_include),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.news_list_recycler_view),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.news_item_title_text_view), withText("Новость: 1769540301662"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView5.check(matches(withText("Новость: 1769540301662")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.news_item_publication_date_text_view), withText("27.01.2026"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView6.check(matches(withText("27.01.2026")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.news_item_create_date_text_view), withText("01.07.58044"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView7.check(matches(withText("01.07.58044")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.news_item_published_text_view), withText("ACTIVE"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView8.check(matches(withText("ACTIVE")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.news_item_description_text_view), withText("Описание новости: 1769540301662"),
                        withParent(withParent(withId(R.id.news_item_material_card_view))),
                        isDisplayed()));
        textView9.check(matches(withText("Описание новости: 1769540301662")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
