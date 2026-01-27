package ru.iteco.fmhandroid.ui.steps;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
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

    public void assertNewsCategoryDateAndTime(NewsItemInfo info) {
        assertCategory(info.getCategory());
        assertPublicationDate(info.getPublicationDate());
        assertPublicationTime(info.getPublicationTime());
    }

    public void createNews(NewsItemInfo info) {
        tapOnCategoryField();
        tapOnCategoryItemOnTheList(info.getPosition());
        specifyNewsTitle(info.getTitle());
        tapOnDateField();
        int day = NewsInfoHelper.getDay(info.getPublicationDate());
        int month = NewsInfoHelper.getMonth(info.getPublicationDate());
        int year = NewsInfoHelper.getYear(info.getPublicationDate());
        assignDate(day, month, year);
        tapOnTimeField();
        int hours = NewsInfoHelper.getHour(info.getPublicationTime());
        int minutes = NewsInfoHelper.getMinutes(info.getPublicationTime());
        assignTime(hours, minutes);
        addDescription(info.getDescription());
        assertNewsCategoryDateAndTime(info);
        tapOnSaveButton();
    }

    public void createNewsWithoutCategory(NewsItemInfo info) {
        specifyNewsTitle(info.getTitle());
        tapOnDateField();
        int day = NewsInfoHelper.getDay(info.getPublicationDate());
        int month = NewsInfoHelper.getMonth(info.getPublicationDate());
        int year = NewsInfoHelper.getYear(info.getPublicationDate());
        assignDate(day, month, year);
        tapOnTimeField();
        int hours = NewsInfoHelper.getHour(info.getPublicationTime());
        int minutes = NewsInfoHelper.getMinutes(info.getPublicationTime());
        assignTime(hours, minutes);
        addDescription(info.getDescription());
        tapOnSaveButton();
    }
}
