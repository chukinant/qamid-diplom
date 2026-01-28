package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

import android.content.res.Resources;
import android.widget.ImageButton;

public class TimePickerDialogSteps extends BaseModalWindowSteps {

    public void assignTime(int hour, int minute) {
        onView(allOf(
                isAssignableFrom(ImageButton.class),
                withContentDescription("Switch to text input mode for the time input.")))
                .inRoot(isDialog())
                .perform(click());

        Resources resources = Resources.getSystem();
        int hourInputId = resources.getIdentifier("input_hour", "id", "android");
        int minuteInputId = resources.getIdentifier("input_minute", "id", "android");

        onView(withId(hourInputId))
                .inRoot(isDialog())
                .perform(replaceText(String.valueOf(hour)));

        onView(withId(minuteInputId))
                .inRoot(isDialog())
                .perform(replaceText(String.format("%02d", minute)));

        closeSoftKeyboard();

        tapOnOkButton();
    }
}
