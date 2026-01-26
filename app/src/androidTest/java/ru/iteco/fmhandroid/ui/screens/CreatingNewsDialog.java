package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class CreatingNewsDialog extends BaseNewsDialog {

    private CreatingNewsDialog() {}

    private static final int title = R.string.creating;

    public static void assertTitleIsDisplayed() {
//        Allure.step("Creating News dialog title is displayed");
        createEditNewsDialogTitle.check(matches(isDisplayed()));
        createEditNewsDialogTitle.check(matches(withText(title)));
    }

    public static void assertActivityToggleBarIsDisabled() {
//        Allure.step("News activity toggle bar is disabled");
        toggleBar.check(matches(isDisplayed()));
        toggleBar.check(matches(not(isEnabled())));
    }
}
