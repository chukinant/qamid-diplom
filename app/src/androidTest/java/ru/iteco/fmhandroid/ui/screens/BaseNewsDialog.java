package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class BaseNewsDialog {

    protected static final int viewID = R.id.container_custom_app_bar_include_on_fragment_create_edit_news;
    protected static final ViewInteraction creatingNewsDialogLabel = onView(allOf(withId(R.id.custom_app_bar_title_text_view),
            withParent(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_news))));
    protected static final ViewInteraction categoryField = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    protected static final ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_layout));
    protected static final ViewInteraction publicationDateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    protected static final ViewInteraction publicationTimeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    protected static final ViewInteraction descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
    protected static final ViewInteraction submitButton = onView(withId(R.id.save_button));
    protected static final ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    protected static final int savingFailedMsg = R.string.error_saving;
    protected static final int fillEmptyFieldsMsg = R.string.empty_fields;
    protected static final int changesWontBeSavedMsg = R.string.cancellation;

    public static void tapOnCategoryField() {
//        Allure.step("User taps on the Category field");
        categoryField.perform(click());
    }

    public static void tapOnCategoryItemOnTheList(int position) {
//        Allure.step("User taps on the {int}th item on the dropdown list");
        onData(anything())
                .inRoot(isPlatformPopup())
                .atPosition(position)
                .perform(click());
        categoryField.perform(closeSoftKeyboard());
    }

    public static void tapOnSaveButton() {
//        Allure.step("User taps on Save button");
        submitButton.perform(click());
    }

    public static void assertFillEmptyFieldsMsgIsDisplayed(View decorView) {
//        Allure.step("Toast msg that with text " + fillEmptyFieldsMsg + " is displayed");
        onView(withText(fillEmptyFieldsMsg))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }
}
