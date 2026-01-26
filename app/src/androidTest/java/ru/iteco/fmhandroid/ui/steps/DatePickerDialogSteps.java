package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;

import android.content.res.Resources;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;

import java.util.Locale;

public class DatePickerDialogSteps extends ModalWindowSteps {

    public void assignDate(int daysAhead) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, daysAhead);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH); // 0-based for Calendar
        int year = calendar.get(Calendar.YEAR);

        Resources resources = Resources.getSystem();
        int yearPickerId = resources.getIdentifier("date_picker_year_picker", "id", "android");

        // Material DatePicker opens in year selection mode (YearPickerView is an AdapterView)
        // We need to use onData to select the year first
        try {
            // Try to select year by value (YearPickerView adapter typically contains Integer objects)
            onData(allOf(
                    instanceOf(Integer.class),
                    equalTo(year)))
                    .inAdapterView(withId(yearPickerId))
                    .inRoot(isDialog())
                    .perform(click());
        } catch (Exception e) {
            // Fallback 1: Try position-based selection
            try {
                onData(anything())
                        .inAdapterView(withId(yearPickerId))
                        .inRoot(isDialog())
                        .atPosition(findYearPosition(year))
                        .perform(click());
            } catch (Exception e2) {
                // Fallback 2: Try to find year by text view
                onView(allOf(
                        withText(String.valueOf(year)),
                        isDisplayed()))
                        .inRoot(isDialog())
                        .perform(click());
            }
        }

        // After selecting year, the picker should show month/day view
        // Select the day
        onView(allOf(
                withText(String.valueOf(day)),
                isDisplayed()))
                .inRoot(isDialog())
                .perform(click());

        // Confirm
        onView(withId(android.R.id.button1))
                .inRoot(isDialog())
                .perform(click());
    }

    private int findYearPosition(int targetYear) {
        // Material DatePicker typically shows years in a range around the current year
        // Calculate approximate position based on typical year range
        Calendar current = Calendar.getInstance();
        int currentYear = current.get(Calendar.YEAR);
        int startYear = currentYear - 100; // Material picker usually shows ~200 year range
        return Math.max(0, targetYear - startYear);
    }


    public static String format(Calendar calendar) {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                .format(calendar.getTime());
    }
}
