package ru.iteco.fmhandroid.ui.auxiliaries;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.rules.ExternalResource;

public class ClearAuthAndLaunchRule extends ExternalResource {

    private final Class<? extends Activity> activityClass;
    private ActivityScenario<? extends Activity> scenario;

    public ClearAuthAndLaunchRule(Class<? extends Activity> activityClass) {
        this.activityClass = activityClass;
    }

    @Override
    protected void before() {
        clearAuthState();
        scenario = ActivityScenario.launch(activityClass);
    }

    @Override
    protected void after() {
        if (scenario != null) {
            scenario.close();
        }
    }

    public ActivityScenario<? extends Activity> getScenario() {
        return scenario;
    }

    private void clearAuthState() {
        Context context = InstrumentationRegistry
                .getInstrumentation()
                .getTargetContext();

        context.getSharedPreferences("auth", Context.MODE_PRIVATE)
                .edit()
                .clear()
                .commit();
    }
}

