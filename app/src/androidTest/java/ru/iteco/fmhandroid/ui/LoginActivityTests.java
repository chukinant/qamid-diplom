package ru.iteco.fmhandroid.ui;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTests extends BaseTestLogin {

    @Before
    public void waitForAuthScreen() {
        AuthScreen.waitUntilIsDisplayed();
    }

    @Test
    public void loginSuccessfulTest() {
        AuthScreen.loginAsValidUser();
        MainScreen.assertAllNewsLinkIsDisplayed();
    }

    @Test
    public void loginWithEmptyLoginAndPassword() {
        AuthScreen.loginWithEmptyLoginAndPassword();
        AuthScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed();
    }

    @Test
    public void loginWithEmptyLogin() {
        AuthScreen.loginWithEmptyLogin();
        AuthScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed();
    }

    @Test
    public void loginWithEmptyPassword() {
        AuthScreen.loginWithEmptyPassword();
        AuthScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed();
    }
}
