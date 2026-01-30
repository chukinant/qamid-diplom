package ru.iteco.fmhandroid.ui.tests;

import android.os.SystemClock;
import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.AllureId;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.ControlPanelFilterDialogSteps;
import ru.iteco.fmhandroid.ui.steps.CreateEditNewsModalSteps;
import ru.iteco.fmhandroid.ui.steps.CreatingNewsDialogSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsInfoHelper;
import ru.iteco.fmhandroid.ui.steps.NewsScreenSteps;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;
import ru.iteco.fmhandroid.ui.utils.TestStartup;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class FilterSortNewsTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;
    private final MainScreenSteps mainScreen = new MainScreenSteps();
    private final NewsScreenSteps newsScreen = new NewsScreenSteps();
    private final NewsControlPanelSteps newsControlPanel = new NewsControlPanelSteps();
    private final NavigationBarSteps navigationBar = new NavigationBarSteps();
    private final CreatingNewsDialogSteps creatingNewsDialog = new CreatingNewsDialogSteps();
    private final CreateEditNewsModalSteps modalWindow = new CreateEditNewsModalSteps();
    private final ControlPanelFilterDialogSteps controlPanelFilterDialog = new ControlPanelFilterDialogSteps();

    @Before
    public void setUp() {
        activityRule.getScenario().onActivity(
                activity -> decorView = activity.getWindow().getDecorView()
        );
        TestStartup.ensureLoggedIn();
        mainScreen.tapOnAllNewsLink();
        newsScreen.assertNewsScreenLabelIsDisplayed();
        newsScreen.tapOnPanelEditButton();
        newsControlPanel.assertNewsControlPanelLabelIsDisplayed();
        newsControlPanel.tapOnAddNewsButton();
    }

    @Test
    @DisplayName("Фильтрация новостей по промежутку даты")
    @AllureId("24.1")
    public void successfulNewsFilteringByPublishingDate() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        creatingNewsDialog.fillForm(newsInitialInfo);
        creatingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        NewsItemInfo newsFutureMonthInfo = NewsInfoHelper.getNewsInfoWithAnotherPubDate(newsInitialInfo, 31);
        newsControlPanel.tapOnAddNewsButton();
        creatingNewsDialog.fillForm(newsFutureMonthInfo);
        creatingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardListed(newsFutureMonthInfo);
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnStartPubDateField();
        controlPanelFilterDialog.pickFirstDayOfMonth();
        controlPanelFilterDialog.tapOnEndPubDateField();
        controlPanelFilterDialog.pickLastDayOfMonth();
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        newsControlPanel.assertCardIsNotOnTheList(newsFutureMonthInfo);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории")
    @AllureId("24.2")
    public void successfulNewsFilteringByCategory() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        creatingNewsDialog.fillForm(newsInitialInfo);
        creatingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        NewsItemInfo newsAnotherCatInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsInitialInfo);
        newsControlPanel.tapOnAddNewsButton();
        creatingNewsDialog.fillForm(newsAnotherCatInfo);
        creatingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardListed(newsAnotherCatInfo);
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnCategoryField();
        controlPanelFilterDialog.tapOnCategoryItemOnTheList(newsInitialInfo.getPosition());
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        newsControlPanel.assertCardIsNotOnTheList(newsAnotherCatInfo);
    }
}
