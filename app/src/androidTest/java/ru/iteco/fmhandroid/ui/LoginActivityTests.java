package ru.iteco.fmhandroid.ui;

import android.view.View;

import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LoginActivityTests extends BaseLoginTest {

    private View decorView;
    private final AuthScreenSteps authScreenSteps = new AuthScreenSteps();
    private final MainScreenSteps mainScreenSteps = new MainScreenSteps();

    @Before
    public void setUp() {
        launchRule.getScenario().onActivity(
                activity -> decorView = activity.getWindow().getDecorView()
        );

        AuthScreen.waitUntilIsDisplayed();
    }

    @Test
    public void loginSuccessfulTest() {
        authScreenSteps.loginAsValidUser();
        mainScreenSteps.assertAllNewsLinkIsDisplayed();
    }

    @Test
    public void loginWithEmptyLoginAndPassword() {
        authScreenSteps.loginWithEmptyLoginAndPassword();
        authScreenSteps.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
    }

    @Test
    public void loginWithEmptyLogin() {
        authScreenSteps.loginWithEmptyLogin();
        authScreenSteps.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
    }

    @Test
    public void loginWithEmptyPassword() {
        authScreenSteps.loginWithEmptyPassword();
        authScreenSteps.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
    }

    @Test
    public void loginWithWrongLoginAndPassword() {
        authScreenSteps.loginWithWrongLoginAndPassword();
        authScreenSteps.assertWrongLoginPasswordMsgIsDisplayed(decorView);
    }

}
