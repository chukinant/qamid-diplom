package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.NavigationBar;

public class NavigationBarSteps {

    @Step("User taps on navigation drawer button")
    public void expandNavigationDrawer() {
        NavigationBar.hamburgerButton.perform(click());
    }

    @Step("User taps on 'About' button")
    public void tapOnAboutButton() {
        NavigationBar.navigationDrawerButtonAbout.perform(click());
    }


}
