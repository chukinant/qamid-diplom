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
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.auxiliaries.CustomViewMatcher.waitUntilDisplayed;

import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.auxiliaries.DataHelper;
import ru.iteco.fmhandroid.ui.screens.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.screens.MainScreen;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest extends AuthBaseTest {

   private AuthorizationScreen authScreen = new AuthorizationScreen();
   private MainScreen mainScreen = new MainScreen();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void loginSuccessfulTest() {
        authScreen.waitUntilIsDisplayed();
        authScreen.setLogin(DataHelper.getValidCredentials().getLogin());
        authScreen.setPassword(DataHelper.getValidCredentials().getPassword());
        authScreen.submit();
        mainScreen.waitUntilIsDisplayed();
        ViewInteraction textView = onView(withId(R.id.all_news_text_view));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("ALL NEWS")));
    }
}
