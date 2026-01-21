package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import org.junit.Before;
import org.junit.Test;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.NavigationBar;

public class NavigationBarSteps {

    public void expandNavigationDrawer() {
        Allure.step("User taps on navigation drawer button");
        NavigationBar.hamburgerButton.perform(click());
    }

    public void tapOnAboutButton() {
        Allure.step("User taps on 'About' button");
        NavigationBar.navigationDrawerButtonAbout.perform(click());
    }

    public void tapProfileButton() {
        Allure.step("User taps on 'About' button");
        NavigationBar.profileButton.perform(click());
    }

    public void tapLogoutButton() {
        Allure.step("User taps on 'Logout' button");
        NavigationBar.profileButtonLogout.perform(click());
    }

}
