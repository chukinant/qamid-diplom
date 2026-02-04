package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.UriMatchers.hasHost;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasToString;

import android.content.Intent;
import android.os.SystemClock;

import androidx.test.espresso.intent.Intents;
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
import ru.iteco.fmhandroid.ui.steps.AboutScreenSteps;
import ru.iteco.fmhandroid.ui.steps.AuthScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;
import ru.iteco.fmhandroid.ui.steps.OurMissionScreenSteps;
import ru.iteco.fmhandroid.ui.utils.TestStartup;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NavigationTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private final OurMissionScreenSteps ourMissionScreen = new OurMissionScreenSteps();
    private final NavigationBarSteps navigationBar = new NavigationBarSteps();
    private final AboutScreenSteps aboutScreen = new AboutScreenSteps();
    private final AuthScreenSteps authScreen = new AuthScreenSteps();

    @Before
    public void setUp() {
        TestStartup.ensureLoggedIn();
    }

    @Test
    @DisplayName("Выход из сессии")
    @AllureId("6")
    public void successfulLogout() {
        navigationBar.assertProfileButtonIsDisplayed();
        navigationBar.tapProfileButton();
        navigationBar.assertProfileButtonLogoutIsDisplayed();
        navigationBar.tapLogoutButton();
        authScreen.assertIsDisplayed();
    }

    @Test
    @DisplayName("Просмотр описания карточки в разделе цитат")
    @AllureId("7")
    public void viewingOurMissionCardDescription() {
        navigationBar.assertOurMissionButtonIsDisplayed();
        navigationBar.tapOurMissionButton();
        ourMissionScreen.assertTitleIsDisplayed();
        ourMissionScreen.tapOnCard(1);
        ourMissionScreen.assertCardHasDescription(1);
    }

    @Test
    @DisplayName("Переход по ссылке на Privacy Policy")
    @AllureId("8")
    public void privacyPolicyRedirection() {
        navigationBar.assertNavigationDrawerButtonIsDisplayed();
        navigationBar.expandNavigationDrawer();
        navigationBar.assertAboutButtonIsDisplayed();
        navigationBar.tapOnAboutButton();
        aboutScreen.assertVersionLabelIsDisplayed();
        Intents.init();
        aboutScreen.tapOnPrivacyPolicyLink();
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(hasHost("vhospice.org"))));
        intended(hasData(hasToString(containsString("privacy-policy"))));
        Intents.release();
    }

    @Test
    @DisplayName("Переход по ссылке на Terms of Use")
    @AllureId("9")
    public void termsOfUseRedirection() {
        navigationBar.assertNavigationDrawerButtonIsDisplayed();
        navigationBar.expandNavigationDrawer();
        navigationBar.assertAboutButtonIsDisplayed();
        navigationBar.tapOnAboutButton();
        aboutScreen.assertVersionLabelIsDisplayed();
        Intents.init();
        aboutScreen.tapOnTermsOfUseLink();
        SystemClock.sleep(3000);
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(hasHost("vhospice.org"))));
        intended(hasData(hasToString(containsString("terms-of-use"))));
        Intents.release();
    }
}
