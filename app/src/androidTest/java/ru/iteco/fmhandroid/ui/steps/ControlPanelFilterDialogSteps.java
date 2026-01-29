package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.ControlPanelFilterDialog;

public class ControlPanelFilterDialogSteps extends BaseFilterNewsDialogSteps{

    public static void uncheckActiveNewsCheckBox() {
        Allure.step("User unchecks Active news checkbox");
        ControlPanelFilterDialog.uncheckActiveNewsCheckBox();
    }

    public static void uncheckNotActiveNewsCheckBox() {
        Allure.step("User unchecks Not Active news checkbox");
        ControlPanelFilterDialog.uncheckNotActiveNewsCheckBox();
    }
}
