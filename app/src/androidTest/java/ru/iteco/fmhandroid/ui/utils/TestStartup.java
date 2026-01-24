package ru.iteco.fmhandroid.ui.utils;

import ru.iteco.fmhandroid.ui.screens.AuthScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;
import ru.iteco.fmhandroid.ui.screens.NavigationBar;

public final class TestStartup {

    private TestStartup() {
    }

        public static void ensureLoggedIn() {
            try {
                MainScreen.waitUntilIsDisplayed();
            } catch (Throwable ignored) {
                AuthScreen.loginAsValidUser();
                MainScreen.waitUntilIsDisplayed();
            }
        }

        public static void ensureNotLoggedIn() {
            try {
                AuthScreen.waitUntilIsDisplayed();
            } catch (Throwable ignored) {
                NavigationBar.logout();
                AuthScreen.waitUntilIsDisplayed();
            }
        }
}



