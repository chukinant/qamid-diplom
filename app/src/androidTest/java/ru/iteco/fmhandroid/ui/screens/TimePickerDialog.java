package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import java.util.Locale;

public class TimePickerDialog {

        public void selectTime(int hour, int minute) {

// Switch to text input
            onView(withId(
                    com.google.android.material.R.id.material_clock_toggle
            )).perform(click());


            onView(withId(
                    com.google.android.material.R.id.material_hour_text_input
            )).perform(replaceText(String.valueOf(hour)));


            onView(withId(
                    com.google.android.material.R.id.material_minute_text_input
            )).perform(replaceText(String.format("%02d", minute)));


            closeSoftKeyboard();


            onView(withText(android.R.string.ok)).perform(click());
        }


        public static String format(int hour, int minute) {
            return String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
        }
    }
}
