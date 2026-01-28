package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.CreateEditNewsModal;

public class CreateEditNewsModalSteps extends BaseModalWindowSteps {

    public void assertCancellationMsgIsDisplayed() {
        Allure.step("Cancellation msg is displayed");
        CreateEditNewsModal.assertCancellationMsgIsDisplayed();
    }
}
