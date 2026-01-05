package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.AuxViewMatcher.waitDisplayed;

import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);



    @Test
    public void loginActivityTest() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 5000));

        ViewInteraction loginInputField = onView(allOf(
                isAssignableFrom(EditText.class),
                isDescendantOfA(withId(R.id.login_text_input_layout))));
                loginInputField.check(matches(isDisplayed()));
        loginInputField.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction passwordInputField = onView(allOf(
                isAssignableFrom(EditText.class),
                isDescendantOfA(withId(R.id.password_text_input_layout))));
        passwordInputField.check(matches(isDisplayed()));
        passwordInputField.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction signInButton = onView(withId(R.id.enter_button));
        signInButton.check(matches(isDisplayed()));
        signInButton.perform(click());

        onView(isRoot()).perform(waitDisplayed(R.id.all_news_text_view, 5000));
        ViewInteraction textView = onView(withId(R.id.all_news_text_view));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ALL NEWS")));
    }
}
