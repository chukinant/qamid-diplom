package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.EditingNewsDialog;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class EditingNewsDialogSteps extends BaseNewsDialogSteps {

    public void switchToggleBarToNotActive() {
        Allure.step("User switches activity toggle bar to Not Active position");
        EditingNewsDialog.switchToggleBarToNotActive();
    }

    public void editNewsCardCategory(NewsItemInfo info) {
        Allure.step("User changes different category");
        tapOnCategoryField();
        tapOnCategoryItemOnTheList(info.getPosition());
    }

    public void assertTitleIsDisplayed() {
        Allure.step("Editing News dialog title is displayed");
        EditingNewsDialog.assertTitleIsDisplayed();
    }

    public void assertActivityToggleBarIsEnabled() {
        Allure.step("Activity toggle bar is enabled");
        EditingNewsDialog.assertActivityToggleBarIsEnabled();
    }

}
