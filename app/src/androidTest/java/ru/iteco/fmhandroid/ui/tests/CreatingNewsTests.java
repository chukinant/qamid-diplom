package ru.iteco.fmhandroid.ui.tests;

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
import ru.iteco.fmhandroid.ui.steps.CreatingNewsDialogSteps;
import ru.iteco.fmhandroid.ui.steps.DatePickerDialogSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.ModalWindowSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsInfoHelper;
import ru.iteco.fmhandroid.ui.steps.NewsScreenSteps;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;
import ru.iteco.fmhandroid.ui.utils.TestStartup;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CreatingNewsTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;
    private final MainScreenSteps mainScreen = new MainScreenSteps();
    private final NewsScreenSteps newsScreen = new NewsScreenSteps();
    private final NewsControlPanelSteps newsControlPanel = new NewsControlPanelSteps();
    private final NavigationBarSteps navigationBar = new NavigationBarSteps();
    private final CreatingNewsDialogSteps creatingNewsDialog = new CreatingNewsDialogSteps();
    private final DatePickerDialogSteps datePickerDialog = new DatePickerDialogSteps();
    private final ModalWindowSteps modalWindow = new ModalWindowSteps();

    @Before
    public void setUp() {
        activityRule.getScenario().onActivity(
                activity -> decorView = activity.getWindow().getDecorView()
        );
        TestStartup.ensureLoggedIn();
        mainScreen.tapOnAllNewsLink();
        newsScreen.assertNewsScreenLabelIsDisplayed();
        newsScreen.tapOnEditNewsButton();
        newsControlPanel.assertNewsControlPanelLabelIsDisplayed();
        newsControlPanel.tapOnAddNewsButton();
        creatingNewsDialog.assertCreatingNewsDialogIsDisplayed();
    }

    @Test
    @DisplayName("Успешное создание новости")
    @AllureId("10")
    public void successfulNewsCreation() {
        NewsItemInfo newsItemInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        creatingNewsDialog.createNews(newsItemInfo);
        newsControlPanel.assertNewsCardInfo(newsItemInfo);
        navigationBar.goFromControlPanelToNewsScreen();
        newsScreen.assertNewsScreenLabelIsDisplayed();
        newsScreen.assertNewsCardInfo(newsItemInfo);
        navigationBar.goFromNewsScreenToMain();
        mainScreen.assertAllNewsLinkIsDisplayed();
        mainScreen.assertNewsCardInfo(newsItemInfo);
    }

    @Test
    @DisplayName("Отображение всплывающего сообщения при попытке публикации без категории")
    @AllureId("13")
    public void fillEmptyFieldsMsgIfWithoutCategory() {
        NewsItemInfo newsItemInfo = NewsInfoHelper.getNewsInfoTodayDateFiveHoursAgo();
        newsScreen.tapOnEditNewsButton();
        newsControlPanel.assertNewsControlPanelLabelIsDisplayed();
        newsControlPanel.tapOnAddNewsButton();
        creatingNewsDialog.assertCreatingNewsDialogIsDisplayed();
        creatingNewsDialog.createNewsWithoutCategory(newsItemInfo);
        creatingNewsDialog.assertFillEmptyFieldsMsgIsDisplayed(decorView);
    }
}

