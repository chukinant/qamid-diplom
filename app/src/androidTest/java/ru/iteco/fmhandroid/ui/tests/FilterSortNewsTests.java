package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.AllureId;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.ControlPanelFilterDialogSteps;
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
    private final EditingNewsDialogSteps editingNewsDialog = new EditingNewsDialogSteps();
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

    public void createNews(NewsItemInfo info) {
        newsControlPanel.tapOnAddNewsButton();
        creatingNewsDialog.fillForm(info);
        creatingNewsDialog.tapOnSaveButton();
        newsControlPanel.assertNewsCardListed(info);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории и промежутку дат")
    @AllureId("24")
    public void successfulNewsFilteringByCategoryAndPubDate() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsInitialInfo);
        NewsItemInfo newsAnotherCatInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsInitialInfo);
        createNews(newsAnotherCatInfo);
        NewsItemInfo newsFutureMonthInfo = NewsInfoHelper.getNewsInfoWithAnotherPubDate(newsInitialInfo, 31);
        createNews(newsFutureMonthInfo);
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnCategoryField();
        controlPanelFilterDialog.tapOnCategoryItemOnTheList(newsInitialInfo.getPosition());
        controlPanelFilterDialog.tapOnStartPubDateField();
        controlPanelFilterDialog.pickFirstDayOfMonth();
        controlPanelFilterDialog.tapOnEndPubDateField();
        controlPanelFilterDialog.pickLastDayOfMonth();
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        newsControlPanel.assertNewsCardNotListed(newsAnotherCatInfo);
        newsControlPanel.assertNewsCardNotListed(newsFutureMonthInfo);
    }

    @Test
    @DisplayName("Фильтрация новостей по категории")
    @AllureId("33")
    public void successfulNewsFilteringByCategory() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsInitialInfo);
        NewsItemInfo newsAnotherCatInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsInitialInfo);
        createNews(newsAnotherCatInfo);
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnCategoryField();
        controlPanelFilterDialog.tapOnCategoryItemOnTheList(newsInitialInfo.getPosition());
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        newsControlPanel.assertNewsCardNotListed(newsAnotherCatInfo);
    }

    @Test
    @DisplayName("Отмена фильтрации новостей")
    @AllureId("25")
    public void filteringCancellation() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsInitialInfo);
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnCancelButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
    }

    @Test
    @DisplayName("Фильтрация новостей не заполняя категорию и диапазон дат")
    @AllureId("26")
    public void filteringWithNoParametersSpecified() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsInitialInfo);
        NewsItemInfo newsAnotherCatInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsInitialInfo);
        createNews(newsAnotherCatInfo);
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        newsControlPanel.assertNewsCardListed(newsAnotherCatInfo);
    }

    @Test
    @DisplayName("Фильтрация неактивных новостей")
    @AllureId("27")
    public void filteringNotActiveNews() {
        NewsItemInfo newsActiveInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsActiveInfo);
        NewsItemInfo newsNotActiveInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsActiveInfo);
        createNews(newsNotActiveInfo);
        newsControlPanel.tapOnEditNewsCardButton(newsNotActiveInfo);
        editingNewsDialog.switchToggleBarToNotActive();
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.uncheckActiveNewsCheckbox();
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardNotListed(newsActiveInfo);
        newsControlPanel.assertNewsCardListed(newsNotActiveInfo);
    }

    @Test
    @DisplayName("Фильтрация активных новостей")
    @AllureId("28")
    public void filteringActiveNews() {
        NewsItemInfo newsActiveInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsActiveInfo);
        NewsItemInfo newsNotActiveInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsActiveInfo);
        createNews(newsNotActiveInfo);
        newsControlPanel.tapOnEditNewsCardButton(newsNotActiveInfo);
        editingNewsDialog.switchToggleBarToNotActive();
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.uncheckNotActiveNewsCheckbox();
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardListed(newsActiveInfo);
        newsControlPanel.assertNewsCardNotListed(newsNotActiveInfo);
    }

    @Test
    @DisplayName("Фильтрация новостей с неотмеченными чекбоксами Active/Not Active")
    @AllureId("29")
    public void filteringWithUncheckedCheckboxesActiveNotActive() {
        NewsItemInfo newsActiveInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsActiveInfo);
        NewsItemInfo newsNotActiveInfo = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsActiveInfo);
        createNews(newsNotActiveInfo);
        newsControlPanel.tapOnEditNewsCardButton(newsNotActiveInfo);
        editingNewsDialog.switchToggleBarToNotActive();
        editingNewsDialog.tapOnSaveButton();
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.uncheckActiveNewsCheckbox();
        controlPanelFilterDialog.uncheckNotActiveNewsCheckbox();
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardNotListed(newsActiveInfo);
        newsControlPanel.assertNewsCardNotListed(newsNotActiveInfo);
    }

    @Test
    @DisplayName("Фильтрация новостей по промежутку даты")
    @AllureId("30")
    public void successfulNewsFilteringByPublishingDate() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsInitialInfo);
        NewsItemInfo newsFutureMonthInfo = NewsInfoHelper.getNewsInfoWithAnotherPubDate(newsInitialInfo, 31);
        createNews(newsFutureMonthInfo);
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnStartPubDateField();
        controlPanelFilterDialog.pickFirstDayOfMonth();
        controlPanelFilterDialog.tapOnEndPubDateField();
        controlPanelFilterDialog.pickLastDayOfMonth();
        controlPanelFilterDialog.tapOnFilterButton();
        newsControlPanel.assertNewsCardListed(newsInitialInfo);
        newsControlPanel.assertNewsCardNotListed(newsFutureMonthInfo);
    }

    @Test
    @DisplayName("Фильтрация новостей от будущей даты до прошедшей даты")
    @AllureId("31")
    public void filteringEndDateIsEarlierThanStart() {
        newsControlPanel.tapOnFilterNewsButton();
        controlPanelFilterDialog.tapOnStartPubDateField();
        controlPanelFilterDialog.pickLastDayOfMonth();
        controlPanelFilterDialog.tapOnEndPubDateField();
        controlPanelFilterDialog.pickFirstDayOfMonth();
        controlPanelFilterDialog.tapOnFilterButton();
        controlPanelFilterDialog.assertWrongPeriodMsgIsDisplayed(decorView);
        controlPanelFilterDialog.assertIsOnScreen();
    }

    @Test
    @DisplayName("Сортировка новостей по убыванию")
    @AllureId("23.1")
    public void sortingNewsDescending() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsInitialInfo);
        NewsItemInfo newsAnotherCatInfo1 = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsInitialInfo);
        createNews(newsAnotherCatInfo1);
        NewsItemInfo newsAnotherCatInfo2 = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsAnotherCatInfo1);
        createNews(newsAnotherCatInfo2);
        newsControlPanel.tapOnSortNewsButton();
        List<String> newsTitles = getNewsTitles();
        newsTitlesAreSortedDescending(newsTitles);
    }

    @Test
    @DisplayName("Сортировка новостей по возрастанию")
    @AllureId("23.2")
    public void sortingNewsAscending() {
        NewsItemInfo newsInitialInfo = NewsInfoHelper.getNewsInfoTodayDateMinuteAgo();
        createNews(newsInitialInfo);
        NewsItemInfo newsAnotherCatInfo1 = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsInitialInfo);
        createNews(newsAnotherCatInfo1);
        NewsItemInfo newsAnotherCatInfo2 = NewsInfoHelper.getNewsInfoWithAnotherCategory(newsAnotherCatInfo1);
        createNews(newsAnotherCatInfo2);
        newsControlPanel.tapOnSortNewsButton();
        newsControlPanel.tapOnSortNewsButton();
        List<String> newsTitles = getNewsTitles();
        newsTitlesAreSortedAscending(newsTitles);
    }

    public static List<String> getNewsTitles() {
        final List<String> titles = new ArrayList<String>();

        onView(withId(R.id.news_list_recycler_view))
                .perform(new ViewAction() {

                    @Override
                    public Matcher<View> getConstraints() {
                        return isAssignableFrom(RecyclerView.class);
                    }

                    @Override
                    public String getDescription() {
                        return "Extracting news titles";
                    }

                    @Override
                    public void perform(UiController uiController, View view) {
                        RecyclerView recyclerView = (RecyclerView) view;
                        RecyclerView.Adapter adapter = recyclerView.getAdapter();

                        for (int i = 0; i < adapter.getItemCount(); i++) {

                            RecyclerView.ViewHolder holder =
                                    recyclerView.findViewHolderForAdapterPosition(i);

                            if (holder == null) {
                                recyclerView.scrollToPosition(i);
                                uiController.loopMainThreadUntilIdle();
                                holder = recyclerView.findViewHolderForAdapterPosition(i);
                            }

                            TextView titleView =
                                    (TextView) holder.itemView
                                            .findViewById(R.id.news_item_title_text_view);

                            titles.add(titleView.getText().toString());
                        }
                    }
                });
        return titles;
    }

    private void newsTitlesAreSortedAscending(List<String> titles) {
        for (int i = 0; i < titles.size() - 1; i++) {
            String current = titles.get(i);
            String next = titles.get(i + 1);

            assertTrue(
                    "ASC sorting failed at index " + i +
                            ": \"" + current + "\" > \"" + next + "\"",
                    current.compareToIgnoreCase(next) <= 0
            );
        }
    }

    private void newsTitlesAreSortedDescending(List<String> titles) {
        for (int i = 0; i < titles.size() - 1; i++) {
            String current = titles.get(i);
            String next = titles.get(i + 1);

            assertTrue(
                    "DESC sorting failed at index " + i +
                            ": \"" + current + "\" < \"" + next + "\"",
                    current.compareToIgnoreCase(next) >= 0
            );
        }
    }
}
