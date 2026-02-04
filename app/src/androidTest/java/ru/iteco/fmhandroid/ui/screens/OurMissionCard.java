package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class OurMissionCard {

    public static void scrollTo(int position) {
        onView(withId(R.id.our_mission_item_list_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(position));
    }

    public static void expand(int position) {
        onView(withId(R.id.our_mission_item_list_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(
                        position, click()));
    }

    public static void scrollExpandedIntoView(int position) {
        onView(withId(R.id.our_mission_item_list_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(position));
    }

    public static void assertHasDescription(int position) {
        onView(withId(R.id.our_mission_item_list_recycler_view))
                .check(matches(atPosition(
                        position,
                        hasDescendant(allOf(
                                withId(R.id.our_mission_item_description_text_view),
                                withText(not(isEmptyOrNullString()))
                        ))
                )));
    }

    private static Matcher<View> atPosition(
            int position,
            Matcher<View> itemMatcher
    ) {
        return new TypeSafeMatcher<View>() {

            @Override
            protected boolean matchesSafely(View view) {
                if (!(view instanceof RecyclerView)) {
                    return false;
                }

                RecyclerView recyclerView = (RecyclerView) view;
                RecyclerView.ViewHolder viewHolder =
                        recyclerView.findViewHolderForAdapterPosition(position);

                if (viewHolder == null) {
                    return false;
                }

                return itemMatcher.matches(viewHolder.itemView);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("has item at position " + position + ": ");
                itemMatcher.describeTo(description);
            }
        };
    }
}
