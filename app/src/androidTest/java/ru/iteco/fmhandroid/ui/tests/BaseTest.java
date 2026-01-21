package ru.iteco.fmhandroid.ui.tests;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;

public class BaseTest {

    @Before
    public void clearAuthState() {
        Context context = InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext();

        context.getSharedPreferences("auth", Context.MODE_PRIVATE)
                .edit()
                .clear()
                .commit();
    }
}
