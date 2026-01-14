package ru.iteco.fmhandroid.ui.steps;

import android.view.View;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;

public class AuthScreenSteps {

    @Step("Login as valid user")
    public void loginAsValidUser() {
        AuthScreen.loginAsValidUser();
    }

    @Step("Login with empty login and empty password")
    public void loginWithEmptyLoginAndPassword() {
        AuthScreen.loginWithEmptyLoginAndPassword();
    }

    @Step("Login with empty password")
    public void loginWithEmptyPassword() {
        AuthScreen.loginWithEmptyPassword();
    }

    @Step("Login with empty login")
    public void loginWithEmptyLogin() {
        AuthScreen.loginWithEmptyLogin();
    }

    @Step("Login with wrong (invalid) login and wrong (invalid) password")
    public void loginWithWrongLoginAndPassword() {
        AuthScreen.loginWithWrongLoginAndPassword();
    }

    @Step("Toast msg that login and/or password cannot be empty is displayed")
    public void assertLoginPasswordCannotBeEmptyMsgIsDisplayed(View decorView) {
        AuthScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
    }

    @Step("Toast msg that 'something went wrong' is displayed")
    public void assertWrongLoginPasswordMsgIsDisplayed(View decorView) {
        AuthScreen.assertWrongLoginPasswordMsgIsDisplayed(decorView);
    }
}

