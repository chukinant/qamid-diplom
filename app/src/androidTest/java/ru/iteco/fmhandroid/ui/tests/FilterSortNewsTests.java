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
    }

    @Test
    @DisplayName("Фильтрация новостей по категории и промежутку даты")
    @AllureId("24")
    public void successfulNewsFiltering() {
        NewsItemInfo newsItemInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        creatingNewsDialog.fillForm(newsItemInfo);
        creatingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardInfo(newsItemInfo);
        navigationBar.goFromControlPanelToNewsScreen();
        newsScreen.assertNewsScreenLabelIsDisplayed();
        newsScreen.assertNewsCardInfo(newsItemInfo);
        navigationBar.goFromNewsScreenToMain();
        mainScreen.assertAllNewsLinkIsDisplayed();
        mainScreen.assertNewsCardInfo(newsItemInfo);
    }
}
