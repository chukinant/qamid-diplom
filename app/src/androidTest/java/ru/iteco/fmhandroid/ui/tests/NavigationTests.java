package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AboutScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;
import ru.iteco.fmhandroid.ui.utils.TestStartup;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NavigationTests {

    @Rule
    public ActivityScenarioRule<AppActivity> activityRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private final MainScreenSteps mainScreenSteps = new MainScreenSteps();
    private final NavigationBarSteps navigationBarSteps = new NavigationBarSteps();
    private final AboutScreenSteps aboutScreenSteps = new AboutScreenSteps();

    @Before
    public void setUp() {
        TestStartup.ensureLoggedIn();
    }

    @Test
    public void navigationFromMainToAboutScreen() {
        navigationBarSteps.expandNavigationDrawer();
        navigationBarSteps.tapOnAboutButton();
        aboutScreenSteps.assertVersionLabelIsDisplayed();
    }

    @Test
    public void successfulLogout() {
        navigationBarSteps.tapProfileButton();
        navigationBarSteps.tapLogoutButton();
    }
}
