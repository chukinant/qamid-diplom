package ru.iteco.fmhandroid.ui;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;

public abstract class BaseTestLogin extends BaseTest {

    @Before
    public void resetAuth() {
        clearAuthState();
    }

    protected void clearAuthState() {
        Context context = InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext();

        SharedPreferences prefs =
                context.getSharedPreferences("auth", Context.MODE_PRIVATE);

        prefs.edit()
                .clear()
                .commit();
    }
}
