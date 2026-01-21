package ru.iteco.fmhandroid.ui.utils;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.NoMatchingViewException;

import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.NavigationBar;

public final class TestStartup {

    private TestStartup() {
    }

        private static final long TIMEOUT = 5_000;

        public static void ensureLoggedIn() {
            try {
                MainScreen.waitUntilIsDisplayed();
            } catch (Throwable ignored) {
                AuthScreen.loginAsValidUser();
                MainScreen.assertIsOnScreen();
            }
        }

        public static void ensureNotLoggedIn() {
            try {
                AuthScreen.waitUntilIsDisplayed();
            } catch (Throwable ignored) {
                NavigationBar.logout();
                AuthScreen.assertIsOnScreen();
            }
        }
}



