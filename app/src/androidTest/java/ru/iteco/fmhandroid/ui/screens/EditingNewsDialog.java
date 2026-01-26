package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;

public class EditingNewsDialog extends BaseNewsDialog {

    private static final int title = R.string.editing;

    public static void assertTitleIsDisplayed() {
//        Allure.step("Editing News dialog title is displayed");
        createEditNewsDialogTitle.check(matches(isDisplayed()));
        createEditNewsDialogTitle.check(matches(withText(title)));
    }

    //    public static void assertActiveToggleIsEnabled() {
//        Allure.step("Active toggle is enabled");
//        createEditNewsDialogTitle.check(matches(isDisplayed()));
//        createEditNewsDialogTitle.check(matches(withText(title)));
//    }

}
