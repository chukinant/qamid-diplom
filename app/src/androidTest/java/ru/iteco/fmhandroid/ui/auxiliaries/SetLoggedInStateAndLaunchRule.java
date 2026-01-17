package ru.iteco.fmhandroid.ui.auxiliaries;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.rules.ExternalResource;

public class SetLoggedInStateAndLaunchRule extends ExternalResource {

    private final Class<? extends Activity> activityClass;
    private ActivityScenario<? extends Activity> scenario;

    public SetLoggedInStateAndLaunchRule(Class<? extends Activity> activityClass) {
        this.activityClass = activityClass;
    }

    public ActivityScenario<? extends Activity> getScenario() {
        return scenario;
    }

    @Override
    protected void before() {
        setLoggedInState();
        scenario = ActivityScenario.launch(activityClass);
    }

    @Override
    protected void after() {
        if (scenario != null) {
            scenario.close();
        }
    }

    protected void setLoggedInState() {
        Context context = ApplicationProvider.getApplicationContext();

        SharedPreferences prefs =
                context.getSharedPreferences("auth", Context.MODE_PRIVATE);

        prefs.edit()
                .putString("access", "test")
                .putString("refresh", "test")
                .commit();
    }

}
