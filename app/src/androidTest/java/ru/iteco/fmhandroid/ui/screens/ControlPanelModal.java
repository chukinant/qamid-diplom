package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import ru.iteco.fmhandroid.R;

public class ControlPanelModal extends BaseModalWindow{

    private static final int deletionMsg = R.string.irrevocable_deletion;

    public static void assertDeletionMsgIsDisplayed() {
//        Allure.step("Deletion msg is displayed");
        onView(withText(deletionMsg))
                .check(matches(isDisplayed()));
    }

}
