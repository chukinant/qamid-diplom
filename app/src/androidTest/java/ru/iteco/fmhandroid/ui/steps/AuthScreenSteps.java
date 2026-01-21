package ru.iteco.fmhandroid.ui.steps;

import android.view.View;

import io.qameta.allure.kotlin.Allure;
import io.qameta.allure.kotlin.AllureId;
import io.qameta.allure.kotlin.Step;
import io.qameta.allure.kotlin.junit4.DisplayName;
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


    public void assertLoginPasswordCannotBeEmptyMsgIsDisplayed(View decorView) {
        Allure.step("Toast msg that login and/or password cannot be empty is displayed");
        AuthScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
    }


    public void assertWrongLoginPasswordMsgIsDisplayed(View decorView) {
        Allure.step("Toast msg that 'something went wrong' is displayed");
        AuthScreen.assertWrongLoginPasswordMsgIsDisplayed(decorView);
    }
}

