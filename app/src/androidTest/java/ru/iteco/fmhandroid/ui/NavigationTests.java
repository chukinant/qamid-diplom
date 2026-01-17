package ru.iteco.fmhandroid.ui;

import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AboutScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NavigationBarSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NavigationTests extends BaseTestLoggedIn {

    private final MainScreenSteps mainScreenSteps = new MainScreenSteps();
    private final NavigationBarSteps navigationBarSteps = new NavigationBarSteps();
    private final AboutScreenSteps aboutScreenSteps = new AboutScreenSteps();

    @Before
    public void setUp() {
        MainScreen.waitUntilIsDisplayed();
    }

    @Test
    public void navigationFromMainToAboutScreen() {
        navigationBarSteps.expandNavigationDrawer();
        navigationBarSteps.tapOnAboutButton();
        aboutScreenSteps.assertVersionLabelIsDisplayed();
    }
}
