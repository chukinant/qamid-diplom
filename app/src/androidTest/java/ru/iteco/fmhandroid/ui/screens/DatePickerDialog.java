package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;

import java.util.Locale;

public class DatePickerDialog {

    public void selectFutureDate(int daysAhead) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, daysAhead);


        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);


// Click day cell (Material renders day as text)
        onView(allOf(
                withText(String.valueOf(day)),
                isDisplayed()
        )).perform(click());


// Confirm
        onView(withText(android.R.string.ok)).perform(click());
    }


    public static String format(Calendar calendar) {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                .format(calendar.getTime());
    }
}
