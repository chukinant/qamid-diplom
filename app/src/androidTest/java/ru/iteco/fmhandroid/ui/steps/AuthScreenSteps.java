package ru.iteco.fmhandroid.ui.steps;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;

public class AuthScreenSteps {


    public void loginAsValidUser() {
        Allure.step("Login with valid credentials");
        AuthScreen.loginAsValidUser();
    }


    public void loginWithEmptyLoginAndPassword() {
        Allure.step("Login with empty login and empty password");
        AuthScreen.loginWithEmptyLoginAndPassword();
    }


    public void loginWithEmptyPassword() {
        Allure.step("Login with empty password");
        AuthScreen.loginWithEmptyPassword();
    }


    public void loginWithEmptyLogin() {
        Allure.step("Login with empty login");
        AuthScreen.loginWithEmptyLogin();
    }


    public void loginWithWrongLoginAndPassword() {
        Allure.step("Login with wrong (invalid) login and wrong (invalid) password");
        AuthScreen.loginWithWrongLoginAndPassword();
    }

    public void assertIsDisplayed() {
        Allure.step("Authorization screen is displayed");
        AuthScreen.assertIsOnScreen();
    }

    public void assertLoginPasswordCannotBeEmptyMsgIsDisplayed(View decorView) {
        Allure.step("Toast msg that login and/or password cannot be empty is displayed");
        AuthScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
    }


    public void assertWrongLoginPasswordMsgIsDisplayed(View decorView) {
        Allure.step("Toast msg that 'something went wrong' is displayed");
        AuthScreen.assertWrongLoginPasswordMsgIsDisplayed(decorView);
    }
}

