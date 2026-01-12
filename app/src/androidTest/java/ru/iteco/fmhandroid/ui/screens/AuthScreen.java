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
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.auxiliaries.CustomViewWaiter.waitUntilDisplayed;

import android.widget.EditText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewInteraction;

import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.testdata.Credentials;
import ru.iteco.fmhandroid.ui.testdata.TestUsers;

public class AuthScreen {

    private AuthScreen() {}

    private static final int viewID = R.id.login_text_input_layout;
    private static final ViewInteraction loginInputField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.login_text_input_layout))));
    private static final ViewInteraction passwordInputField = onView(allOf(
            isAssignableFrom(EditText.class),
            isDescendantOfA(withId(R.id.password_text_input_layout))));
    private static final ViewInteraction signInButton = onView(withId(R.id.enter_button));

    public static void  waitUntilIsDisplayed () {
        onView(isRoot()).perform(waitUntilDisplayed(viewID, 5000));
    }

    private static void enterLogin (String login) {
        loginInputField.check(matches(isDisplayed()));
        loginInputField.perform(replaceText(login), closeSoftKeyboard());
    }

    private static void enterPassword (String password) {
        passwordInputField.check(matches(isDisplayed()));
        passwordInputField.perform(replaceText(password), closeSoftKeyboard());
    }

    private static void submit () {
        signInButton.check(matches(isDisplayed()));
        signInButton.perform(click());
    }

    public static void login(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        submit();
    }

    public static void loginAsValidUser() {
        login(TestUsers.VALID.getLogin(), TestUsers.VALID.getPassword());
    }

    public static void loginWithEmptyLoginAndPassword() {
        submit();
    }

    public static void loginWithEmptyLogin() {
        login(TestUsers.EMPTY.getLogin(), TestUsers.VALID.getPassword());
    }

    public static void loginWithEmptyPassword() {
        login(TestUsers.VALID.getLogin(), TestUsers.EMPTY.getPassword());
    }

    public static void assertLoginPasswordCannotBeEmptyMsgIsDisplayed() {
        onView(withText(R.string.login_error))
                .check(matches(isDisplayed()));
    }

//    public static void assertSmthWentWrongMsgIsDisplayed() {
//        onView(withText(R.string.login_error))
//                .check(matches(isDisplayed()));
//    }

}
