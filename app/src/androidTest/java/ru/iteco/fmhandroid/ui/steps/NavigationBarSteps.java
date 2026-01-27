package ru.iteco.fmhandroid.ui.steps;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.NavigationBar;

public class NavigationBarSteps {

    public void expandNavigationDrawer() {
        Allure.step("User taps on navigation drawer button");
        NavigationBar.tapOnNavigationDrawer();
    }

    public void tapOnAboutButton() {
        Allure.step("User taps on 'About' button");
        NavigationBar.tapOnAboutButton();
    }

    public void tapProfileButton() {
        Allure.step("User taps on profile button");
        NavigationBar.tapOnProfileButton();
    }

    public void tapLogoutButton() {
        Allure.step("User taps on 'Logout' button");
        NavigationBar.tapLogoutButton();
    }

    public void tapMainButton() {
        Allure.step("User taps on 'Main' button");
        NavigationBar.tapOnMainButton();
    }

    public void tapNewsButton() {
        Allure.step("User taps on 'News' button");
        NavigationBar.tapOnNewsButton();
    }

    public void tapOurMissionButton() {
        Allure.step("User taps on 'Our mission' button");
        NavigationBar.tapOnOurMissionButton();
    }

    public void goFromControlPanelToNewsScreen() {
        Allure.step("Transfer is made from Control panel to News screen");
        NavigationBar.tapOnNavigationDrawer();
        NavigationBar.tapOnNewsButton();
    }

    public void goFromNewsScreenToMain() {
        Allure.step("Transfer is made from News screen to Main screen");
        NavigationBar.tapOnNavigationDrawer();
        NavigationBar.tapOnMainButton();
    }

    public void assertIsDisplayed() {
        Allure.step("Navigation bar is displayed");
        NavigationBar.assertIsOnScreen();
    }

    public void assertNavigationDrawerButtonIsDisplayed() {
        Allure.step("Navigation drawer is displayed");
        NavigationBar.assertHamburgerButtonIsDisplayed();
    }

    public void assertOurMissionButtonIsDisplayed() {
        Allure.step("Our mission button is displayed");
        NavigationBar.assertOurMissionButtonIsDisplayed();
    }

    public void assertProfileButtonIsDisplayed() {
        Allure.step("Profile button is displayed");
        NavigationBar.assertProfileButtonIsDisplayed();
    }

    public void assertProfileButtonLogoutIsDisplayed() {
        Allure.step("Logout button is displayed");
        NavigationBar.assertProfileButtonLogoutIsDisplayed();
    }

    public void assertNewsButtonIsDisplayed() {
        Allure.step("News button is displayed");
        NavigationBar.assertNavigationDrawerButtonNewsIsDisplayed();
    }

    public void assertAboutButtonIsDisplayed() {
        Allure.step("About button is displayed");
        NavigationBar.assertNavigationDrawerButtonAboutIsDisplayed();
    }

    public void assertMainButtonIsDisplayed() {
        Allure.step("Main button is displayed");
        NavigationBar.assertNavigationDrawerButtonMainIsDisplayed();
    }
}
