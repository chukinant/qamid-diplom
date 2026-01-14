package ru.iteco.fmhandroid.ui;

import org.junit.Rule;
import org.junit.rules.TestRule;

import ru.iteco.fmhandroid.ui.auxiliaries.ClearAuthAndLaunchRule;

public abstract class BaseLoginTest extends BaseTest {

    protected final ClearAuthAndLaunchRule launchRule =
            new ClearAuthAndLaunchRule(AppActivity.class);

    @Rule
    public final TestRule rule = launchRule;
}
