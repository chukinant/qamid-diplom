package ru.iteco.fmhandroid.ui;

import org.junit.Rule;
import org.junit.rules.TestRule;

import ru.iteco.fmhandroid.ui.auxiliaries.SetLoggedInStateAndLaunchRule;

public abstract class BaseTestLoggedIn {

    protected final SetLoggedInStateAndLaunchRule launchRule =
            new SetLoggedInStateAndLaunchRule(AppActivity.class);

    @Rule
    public final TestRule rule = launchRule;
}
