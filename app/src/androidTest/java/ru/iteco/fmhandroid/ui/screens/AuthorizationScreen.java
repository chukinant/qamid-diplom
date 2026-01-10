package ru.iteco.fmhandroid.ui.screens;

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

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.auxiliaries.CustomViewMatcher.waitUntilDisplayed;

import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthorizationScreen {

    public final int viewID = R.id.login_text_input_layout;
    private final ViewInteraction loginInputField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.login_text_input_layout))));
    private final ViewInteraction passwordInputField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.password_text_input_layout))));
    private final ViewInteraction signInButton = onView(withId(R.id.enter_button));

    public void waitUntilIsDisplayed () {
    onView(isRoot()).perform(waitUntilDisplayed(viewID, 5000));
    }

    public void setLogin (String login) {
        loginInputField.check(matches(isDisplayed()));
        loginInputField.perform(replaceText(login), closeSoftKeyboard());
    }

    public void setPassword (String password) {
        passwordInputField.check(matches(isDisplayed()));
        passwordInputField.perform(replaceText(password), closeSoftKeyboard());
    }

    public void submit () {
        signInButton.check(matches(isDisplayed()));
        signInButton.perform(click());
    }
}
