package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;

import android.icu.util.Calendar;
import android.widget.DatePicker;

import androidx.test.espresso.contrib.PickerActions;

public class DatePickerDialogSteps extends ModalWindowSteps {

    public void assignDate(int day, int month, int year) {
        onView(isAssignableFrom(DatePicker.class))
                .perform(PickerActions.setDate(year, month, day));
        tapOnOkButton();
    }

    public void pickFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 1-based
        int day = 1;
        onView(isAssignableFrom(DatePicker.class))
                .perform(PickerActions.setDate(year, month, day));
        tapOnOkButton();
    }

    public void pickLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 1-based
        int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        onView(isAssignableFrom(DatePicker.class))
                .perform(PickerActions.setDate(year, month, day));
        tapOnOkButton();
    }

//
//    public static String format(Calendar calendar) {
//        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
//                .format(calendar.getTime());
//    }
}
