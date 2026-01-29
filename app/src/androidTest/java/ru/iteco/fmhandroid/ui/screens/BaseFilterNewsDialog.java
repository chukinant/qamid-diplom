package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static ru.iteco.fmhandroid.ui.utils.ViewWaiterAndMatcher.waitUntilDisplayed;

import android.widget.EditText;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class BaseFilterNewsDialog {

    protected static final int waitingForID = R.id.filter_news_title_text_view;
    protected static ViewInteraction filterNewsDialogTitle = onView(allOf(withId(R.id.filter_news_title_text_view),
                                                                            withText(R.string.filter_news)));
    protected static ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    protected static ViewInteraction startPubDateField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.news_item_publish_date_start_text_input_layout))));
    protected static ViewInteraction endPubDateField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.news_item_publish_date_end_text_input_layout))));
    protected static ViewInteraction filterButton = onView(withId(R.id.save_button));
    protected static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
//    protected static final int savingFailedMsg = R.string.error_saving;
//    protected static final int fillEmptyFieldsMsg = R.string.empty_fields;
//    protected static final int changesWontBeSavedMsg = R.string.cancellation;

    public static void assertIsOnScreen() {
//        Allure.step("Filter News dialog is displayed");
        onView(isRoot()).perform(waitUntilDisplayed(waitingForID, 5000));
    }

    public static void assertElementsAreDisplayed() {
//        Allure.step("Fields and buttons are displayed");
        categoryField.check(matches(isDisplayed()));
        startPubDateField.check(matches(isDisplayed()));
        endPubDateField.check(matches(isDisplayed()));
        filterButton.check(matches(isDisplayed()));
        cancelButton.check(matches(isDisplayed()));
    }

    public static void tapOnCategoryField() {
//        Allure.step("User taps on the Category field");
        categoryField.check(matches(isDisplayed()));
        categoryField.perform(click());
    }

    public static void tapOnCategoryItemOnTheList(int position) {
//        Allure.step("User taps on the " + position + "th item on the dropdown list");
        DataInteraction interaction = onData(anything())
                .inRoot(isPlatformPopup())
                .atPosition(position);
        interaction.perform(click());
//        try {
//            onData(anything()).inRoot(isPlatformPopup()).
//                    atPosition(position).perform(click());
//        } catch (NoMatchingViewException e) {
//            clickPopupItemByPosition(position);
//        }
        categoryField.perform(closeSoftKeyboard());
    }

    public static void tapOnStartPubDateField() {
//        Allure.step("User taps on starting publication date field");
        startPubDateField.check(matches(isDisplayed()));
        startPubDateField.perform(click());
    }

    public static void tapOnEndPubDateField() {
//        Allure.step("User taps on starting publication date field");
        endPubDateField.check(matches(isDisplayed()));
        endPubDateField.perform(click());
    }

    public static void tapOnCancelButton() {
//        Allure.step("User taps on Cancel button");
        cancelButton.check(matches(isDisplayed()));
        cancelButton.perform(click());
    }

    public static void tapOnFilterButton() {
//        Allure.step("User taps on Filter button");
        filterButton.check(matches(isDisplayed()));
        filterButton.perform(click());
    }

    public static void assertFilterNewsDialogTitleIsDisplayed() {
        filterNewsDialogTitle.check(matches(isDisplayed()));
    }

    public static void assertStartPubDate(String date) {
//      Allure.step("Assert chosen starting publication date");
        startPubDateField.check(matches(isDisplayed()));
        startPubDateField.check(matches(withText(date)));
    }

    public static void assertEndPubDate(String date) {
//      Allure.step("Assert chosen starting publication date");
        endPubDateField.check(matches(isDisplayed()));
        endPubDateField.check(matches(withText(date)));
    }
}
