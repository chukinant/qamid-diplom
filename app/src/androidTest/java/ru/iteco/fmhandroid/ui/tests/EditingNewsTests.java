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
import ru.iteco.fmhandroid.ui.steps.CreateEditNewsModalSteps;
import ru.iteco.fmhandroid.ui.steps.CreatingNewsDialogSteps;
import ru.iteco.fmhandroid.ui.steps.EditingNewsDialogSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsInfoHelper;
import ru.iteco.fmhandroid.ui.steps.NewsScreenSteps;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;
import ru.iteco.fmhandroid.ui.utils.TestStartup;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class EditingNewsTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;
    private final MainScreenSteps mainScreen = new MainScreenSteps();
    private final NewsScreenSteps newsScreen = new NewsScreenSteps();
    private final NewsControlPanelSteps newsControlPanel = new NewsControlPanelSteps();
    private final NavigationBarSteps navigationBar = new NavigationBarSteps();
    private final CreatingNewsDialogSteps creatingNewsDialog = new CreatingNewsDialogSteps();
    private final EditingNewsDialogSteps editingNewsDialog = new EditingNewsDialogSteps();
    private final CreateEditNewsModalSteps modalWindow = new CreateEditNewsModalSteps();
    private final NewsItemInfo initialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();


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
        creatingNewsDialog.assertCreatingNewsDialogIsDisplayed();
        creatingNewsDialog.fillForm(initialInfo);
        creatingNewsDialog.tapOnSaveButton();
    }

    @Test
    @DisplayName("Редактирование категории новости")
    @AllureId("19")
    public void editNewsCategory() {
        newsControlPanel.tapOnEditNewsCardButton(initialInfo);
        editingNewsDialog.assertTitleIsDisplayed();
        NewsItemInfo editedInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(initialInfo);
        editingNewsDialog.editNewsCardCategory(editedInfo);
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardInfo(editedInfo);
    }

    @Test
    @DisplayName("Редактирование наименования новости")
    @AllureId("20")
    public void editNewsTitle() {
        newsControlPanel.tapOnEditNewsCardButton(initialInfo);
        editingNewsDialog.assertTitleIsDisplayed();
        NewsItemInfo editedInfo = NewsInfoHelper.getNewsInfoWithEditedTitle(initialInfo);
        editingNewsDialog.specifyNewsTitle(editedInfo.getTitle());
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardInfo(editedInfo);
    }

    @Test
    @DisplayName("Редактирование даты публикации новости")
    @AllureId("21")
    public void editNewsPublicationDate() {
        newsControlPanel.tapOnEditNewsCardButton(initialInfo);
        editingNewsDialog.assertTitleIsDisplayed();
        NewsItemInfo editedInfo = NewsInfoHelper.getNewsInfoWithEditedPubDate(initialInfo, 1);
        int day = NewsInfoHelper.getDay(editedInfo.getPublicationDate());
        int month = NewsInfoHelper.getMonth(editedInfo.getPublicationDate());
        int year = NewsInfoHelper.getYear(editedInfo.getPublicationDate());
        editingNewsDialog.tapOnDateField();
        editingNewsDialog.assignDate(day, month, year);
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardInfo(editedInfo);
    }

    @Test
    @DisplayName("Редактирование описания новости")
    @AllureId("22")
    public void editNewsDescription() {
        newsControlPanel.tapOnEditNewsCardButton(initialInfo);
        editingNewsDialog.assertTitleIsDisplayed();
        NewsItemInfo editedInfo = NewsInfoHelper.getNewsInfoWithEditedDescription(initialInfo);
        editingNewsDialog.addDescription(editedInfo.getDescription());
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardInfo(editedInfo);
    }

    @Test
    @DisplayName("Редактирование статуса новости")
    @AllureId("32")
    public void editNewsActivityStatus() {
        newsControlPanel.tapOnEditNewsCardButton(initialInfo);
        editingNewsDialog.assertTitleIsDisplayed();
        NewsItemInfo editedInfo = NewsInfoHelper.getNewsInfoWithChangedStatus(initialInfo);
        editingNewsDialog.switchToggleBarToNotActive();
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardInfo(editedInfo);
    }
}


