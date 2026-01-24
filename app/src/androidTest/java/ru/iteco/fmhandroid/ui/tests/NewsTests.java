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
import ru.iteco.fmhandroid.ui.screens.CreatingNewsDialog;
import ru.iteco.fmhandroid.ui.steps.AboutScreenSteps;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;
import ru.iteco.fmhandroid.ui.steps.CreatingNewsDialogSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsScreenSteps;
import ru.iteco.fmhandroid.ui.utils.TestStartup;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;

    private final MainScreenSteps mainScreenSteps = new MainScreenSteps();
    private final NewsScreenSteps newsScreenSteps = new NewsScreenSteps();
    private final NewsControlPanelSteps newsControlPanelSteps = new NewsControlPanelSteps();
    private final NavigationBarSteps navigationBarSteps = new NavigationBarSteps();
    private final CreatingNewsDialogSteps creatingNewsDialogSteps = new CreatingNewsDialogSteps();

    @Before
    public void setUp() {
        activityRule.getScenario().onActivity(
                activity -> decorView = activity.getWindow().getDecorView()
        );
        TestStartup.ensureLoggedIn();
        mainScreenSteps.tapOnAllNewsLink();
        newsScreenSteps.assertNewsScreenLabelIsDisplayed();
    }

    @Test
    @DisplayName("Успешное создание новости")
    @AllureId("10")
    public void successfulNewsCreation() {
        newsScreenSteps.tapOnEditNewsButton();
        newsControlPanelSteps.assertNewsControlPanelLabelIsDisplayed();
        newsControlPanelSteps.tapOnAddNewsButton();
        creatingNewsDialogSteps.assertIsOnScreen();
        creatingNewsDialogSteps.tapOnCategoryField();
        creatingNewsDialogSteps.tapOnCategoryItemOnTheList(1);

        creatingNewsDialogSteps.tapOnSaveButton();
        creatingNewsDialogSteps.assertFillEmptyFieldsMsgIsDisplayed(decorView);
//      creatingNewsDialog.createNews(NewsData.par1,NewsData.par2,NewsData.par4,NewsData.par4)
    }

    @Test
    @DisplayName("Отображение всплывающего сообщения при попытке публикации только с заполненной категорией новости")
    @AllureId("-")
    public void fillEmptyFieldsMsgWhenOnlyCategoryIsFilled() {
        newsScreenSteps.tapOnEditNewsButton();
        newsControlPanelSteps.assertNewsControlPanelLabelIsDisplayed();
        newsControlPanelSteps.tapOnAddNewsButton();
        creatingNewsDialogSteps.assertIsOnScreen();
        creatingNewsDialogSteps.tapOnCategoryField();
        creatingNewsDialogSteps.tapOnCategoryItemOnTheList(1);
        creatingNewsDialogSteps.tapOnSaveButton();
        creatingNewsDialogSteps.assertFillEmptyFieldsMsgIsDisplayed(decorView);
    }

}

