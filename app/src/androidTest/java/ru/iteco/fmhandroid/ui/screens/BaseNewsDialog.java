package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

import android.view.View;
import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class BaseNewsDialog {

    protected static final int viewID = R.id.container_custom_app_bar_include_on_fragment_create_edit_news;
    protected static ViewInteraction createEditNewsDialogTitle = onView(allOf(withId(R.id.custom_app_bar_title_text_view),
            withParent(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news))));
    protected static ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    protected static ViewInteraction titleField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.news_item_title_text_input_layout))));
    protected static ViewInteraction publicationDateField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.news_item_create_date_text_input_layout))));
    protected static ViewInteraction publicationTimeField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.news_item_publish_time_text_input_layout))));
    protected static ViewInteraction descriptionField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.news_item_description_text_input_layout))));
    protected static ViewInteraction saveButton = onView(withId(R.id.save_button));
    protected static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    protected static ViewInteraction toggleBar = onView(withId(R.id.switcher));
    protected static final int savingFailedMsg = R.string.error_saving;
    protected static final int fillEmptyFieldsMsg = R.string.empty_fields;
    protected static final int changesWontBeSavedMsg = R.string.cancellation;

    public static void assertIsOnScreen() {
//        Allure.step("Creating/Editing News dialog is displayed");
        onView(withId(BaseNewsDialog.viewID)).check(matches(isDisplayed()));
    }

    public static void assertFieldsAreDisplayed() {
//        Allure.step("Category, Title, Publication date, Time, Description fields are displayed");
        categoryField.check(matches(isDisplayed()));
        titleField.check(matches(isDisplayed()));
        publicationDateField.check(matches(isDisplayed()));
        publicationTimeField.check(matches(isDisplayed()));
        descriptionField.check(matches(isDisplayed()));
    }

    public static void tapOnCategoryField() {
//        Allure.step("User taps on the Category field");
        categoryField.check(matches(isDisplayed()));
        categoryField.perform(click());
    }

    public static void tapOnCategoryItemOnTheList(int position) {
//        Allure.step("User taps on the Nth item on the dropdown list");
        onData(anything())
                .inRoot(isPlatformPopup())
                .atPosition(position)
                .perform(click());
        categoryField.perform(closeSoftKeyboard());
    }

    public static void specifyNewsTitle(String title) {
//      Allure.step("User specifies news title");
        titleField.check(matches(isDisplayed()));
        titleField.perform(click());
        titleField.perform(replaceText(title), closeSoftKeyboard());
    }

    public static void tapOnDateField() {
//        Allure.step("User taps on publication date field");
        publicationDateField.check(matches(isDisplayed()));
        publicationDateField.perform(click());
    }

    public static void tapOnTimeField() {
//        Allure.step("User taps on publication time field");
        publicationTimeField.check(matches(isDisplayed()));
        publicationTimeField.perform(click());
    }

    public static void addDescription(String description) {
//        Allure.step("User adds news description");
        descriptionField.check(matches(isDisplayed()));
        descriptionField.perform(click());
        descriptionField.perform(replaceText(description), closeSoftKeyboard());
    }

    public static void tapOnCancelButton() {
//        Allure.step("User taps on Cancel button");
        cancelButton.check(matches(isDisplayed()));
        cancelButton.perform(click());
    }

    public static void tapOnSaveButton() {
//        Allure.step("User taps on Save button");
        saveButton.check(matches(isDisplayed()));
        saveButton.perform(click());
    }

    public static void assertCategory(String category) {
//      Allure.step("Assert chosen category");
        categoryField.check(matches(isDisplayed()));
        categoryField.check(matches(withText(category)));
    }

    public static void assertPublicationDate(String date) {
//      Allure.step("Publication date field is filled with the chosen date");
        publicationDateField.check(matches(isDisplayed()));
        publicationDateField.check(matches(withText(date)));
    }

    public static void assertPublicationTime(String time) {
//      Allure.step("Publication date field is filled with the chosen date");
        publicationTimeField.check(matches(isDisplayed()));
        publicationTimeField.check(matches(withText(time)));
    }

    public static void assertFillEmptyFieldsMsgIsDisplayed(View decorView) {
//        Allure.step("Toast msg that with text " + fillEmptyFieldsMsg + " is displayed");
        onView(withText(fillEmptyFieldsMsg))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}
