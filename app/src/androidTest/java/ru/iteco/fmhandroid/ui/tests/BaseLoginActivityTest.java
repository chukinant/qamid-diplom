package ru.iteco.fmhandroid.ui.tests;

import org.junit.Rule;
import org.junit.rules.TestRule;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.utils.ClearAuthAndLaunchRule;

public abstract class BaseLoginActivityTest {

    protected final ClearAuthAndLaunchRule launchRule =
            new ClearAuthAndLaunchRule(AppActivity.class);

    @Rule
    public final TestRule rule = launchRule;
}
