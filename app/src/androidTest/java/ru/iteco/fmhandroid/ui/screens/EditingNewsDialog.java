package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.NewsItemInfo;

public class EditingNewsDialog extends BaseNewsDialog {

    private static final int title = R.string.editing;
    private static final int activeLabel = R.string.news_item_active;
    private static final int notActiveLabel = R.string.news_item_not_active;

    public static void switchToggleBarToNotActive() {
//        Allure.step("User switches activity toggle bar to Not Active position");
        toggleBar.check(matches(isDisplayed()));
        toggleBar.check(matches(withText(activeLabel)));
        toggleBar.perform(click());
        toggleBar.check(matches(withText(notActiveLabel)));
    }

    public static void assertTitleIsDisplayed() {
//        Allure.step("Editing News dialog title is displayed");
        createEditNewsDialogTitle.check(matches(isDisplayed()));
        createEditNewsDialogTitle.check(matches(withText(title)));
    }

        public static void assertActivityToggleBarIsEnabled() {
//        Allure.step("Activity toggle bar is enabled");
            toggleBar.check(matches(isDisplayed()));
            toggleBar.check(matches(isEnabled()));
    }

}
