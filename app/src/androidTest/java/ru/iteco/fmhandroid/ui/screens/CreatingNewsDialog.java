package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

import ru.iteco.fmhandroid.R;

public class CreatingNewsDialog extends BaseNewsDialog {

    private CreatingNewsDialog() {
    }

    private static final int title = R.string.creating;

    public static void assertTitleIsDisplayed() {
//        Allure.step("Creating News dialog title is displayed");
        createEditNewsDialogTitle.check(matches(isDisplayed()));
        createEditNewsDialogTitle.check(matches(withText(title)));
    }

    public static void assertActivityToggleBarIsDisabled() {
//        Allure.step("News activity toggle bar is disabled");
        toggleBar.check(matches(isDisplayed()));
        toggleBar.check(matches(not(isEnabled())));
    }
}
