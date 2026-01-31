package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.ControlPanelFilterDialog;

public class ControlPanelFilterDialogSteps extends BaseFilterNewsDialogSteps{

    public void uncheckActiveNewsCheckbox() {
        Allure.step("User unchecks Active news checkbox");
        ControlPanelFilterDialog.uncheckActiveNewsCheckbox();
    }

    public void uncheckNotActiveNewsCheckbox() {
        Allure.step("User unchecks Not Active news checkbox");
        ControlPanelFilterDialog.uncheckNotActiveNewsCheckbox();
    }
}
