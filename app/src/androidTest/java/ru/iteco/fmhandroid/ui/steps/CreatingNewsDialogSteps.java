package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screens.CreatingNewsDialog;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class CreatingNewsDialogSteps extends BaseNewsDialogSteps {

    public void assertCreatingNewsDialogIsDisplayed() {
        Allure.step("Creating News dialog is displayed");
        CreatingNewsDialog.assertIsOnScreen();
        CreatingNewsDialog.assertTitleIsDisplayed();
        CreatingNewsDialog.assertFieldsAreDisplayed();
        CreatingNewsDialog.assertActivityToggleBarIsDisabled();
    }

    public void assertCategoryDateTime(NewsItemInfo info) {
        Allure.step("Assert that news category, publication date and time are correct");
        assertCategory(info.getCategory());
        assertPublicationDate(info.getPublicationDate());
        assertPublicationTime(info.getPublicationTime());
    }

    public void createNews(NewsItemInfo info) {
        Allure.step("Create news with valid data");
        tapOnCategoryField();
        tapOnCategoryItemOnTheList(info.getPosition());
        specifyNewsTitle(info.getTitle());
        tapOnDateField();
        new DatePickerDialogSteps().tapOnOkButton();
        tapOnTimeField();
        assignTime(
                NewsInfoHelper.getHour(info.getPublicationTime()),
                NewsInfoHelper.getMinutes(info.getPublicationTime())
        );
        addDescription(info.getDescription());
        assertCategoryDateTime(info);
        tapOnSaveButton();
    }


}
