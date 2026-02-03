package ru.iteco.fmhandroid.ui.tests;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.AllureId;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;
import ru.iteco.fmhandroid.ui.utils.TestStartup;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LoginActivityTests {

    private View decorView;
    private final AuthScreenSteps authScreen = new AuthScreenSteps();
    private final MainScreenSteps mainScreen = new MainScreenSteps();
    private final NavigationBarSteps navigationBar = new NavigationBarSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        activityRule.getScenario().onActivity(
                activity -> decorView = activity.getWindow().getDecorView()
        );

        TestStartup.ensureNotLoggedIn();
    }

    @Test
    @DisplayName("Успешная авторизация")
    @AllureId("1")
    public void loginSuccessfulTest() {
        authScreen.loginAsValidUser();
        navigationBar.assertIsDisplayed();
        mainScreen.assertIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация с пустыми login и password")
    @AllureId("4")
    public void loginWithEmptyLoginAndPassword() {
        authScreen.loginWithEmptyLoginAndPassword();
        authScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
        authScreen.assertIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация с пустым полем login")
    @AllureId("2")
    public void loginWithEmptyLogin() {
        authScreen.loginWithEmptyLogin();
        authScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
        authScreen.assertIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация с пустым полем password")
    @AllureId("3")
    public void loginWithEmptyPassword() {
        authScreen.loginWithEmptyPassword();
        authScreen.assertLoginPasswordCannotBeEmptyMsgIsDisplayed(decorView);
        authScreen.assertIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация с невалидными login и password")
    @AllureId("5")
    public void loginWithWrongLoginAndPassword() {
        authScreen.loginWithWrongLoginAndPassword();
        authScreen.assertWrongLoginPasswordMsgIsDisplayed(decorView);
        authScreen.assertIsDisplayed();
    }

}
