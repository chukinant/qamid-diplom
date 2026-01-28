package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;

import ru.iteco.fmhandroid.R;

public class CreateEditNewsModal extends BaseModalWindow{

    private static final int cancellationMsg = R.string.cancellation;

    public static void assertCancellationMsgIsDisplayed() {
//        Allure.step("Cancellation msg is displayed);
        onView(withText(cancellationMsg))
                .check(matches(isDisplayed()));
    }
}
