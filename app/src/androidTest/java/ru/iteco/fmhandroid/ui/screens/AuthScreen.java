package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.auxiliaries.ViewWaiterAndMatcher.waitUntilDisplayed;

import android.view.View;
import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
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
    private static final String loginPasswordCannotBeEmptyMsg = "Login and password cannot be empty";
    private static final String wrongLoginPasswordMsg = "Something went wrong. Try again later.";


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

    public static void assertLoginPasswordCannotBeEmptyMsgIsDisplayed(View decorView) {
        onView(withText(loginPasswordCannotBeEmptyMsg))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

    public static void loginWithWrongLoginAndPassword() {
        login(TestUsers.WRONG.getLogin(), TestUsers.WRONG.getPassword());
    }

    public static void loginWithWrongLogin() {
        login(TestUsers.WRONG.getLogin(), TestUsers.VALID.getPassword());
    }

    public static void loginWithWrongPassword() {
        login(TestUsers.VALID.getLogin(), TestUsers.WRONG.getPassword());
    }

    public static void assertWrongLoginPasswordMsgIsDisplayed(View decorView) {
        onView(withText(wrongLoginPasswordMsg))
                .inRoot(withDecorView(not(decorView)))
                .check(matches(isDisplayed()));
    }

}
