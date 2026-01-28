package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.matcher.ViewMatchers.withText;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.ControlPanelModal;

public class ControlPanelModalSteps extends BaseModalWindowSteps{

    public static void assertDeletionMsgIsDisplayed() {
        Allure.step("Deletion msg is displayed");
        ControlPanelModal.assertDeletionMsgIsDisplayed();
    }
}
