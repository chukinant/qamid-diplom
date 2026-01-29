package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelFilterDialog extends BaseFilterNewsDialog {

    protected static ViewInteraction activeNewsCheckBox = onView(
            allOf(withId(R.id.filter_news_active_material_check_box),
                    withText(R.string.news_control_panel_active)));
    protected static ViewInteraction notActiveNewsCheckBox = onView(
            allOf(withId(R.id.filter_news_inactive_material_check_box),
                    withText(R.string.news_control_panel_not_active)));

    public static void uncheckActiveNewsCheckBox() {
//        Allure.step("User unchecks Active news checkbox");
        assertChecked(activeNewsCheckBox);
        tapOnCheckbox(activeNewsCheckBox);
    }

    public static void uncheckNotActiveNewsCheckBox() {
//        Allure.step("User unchecks Not Active news checkbox");
        assertChecked(notActiveNewsCheckBox);
        tapOnCheckbox(notActiveNewsCheckBox);
    }

    public static void tapOnCheckbox(ViewInteraction checkbox) {
//        Allure.step("User taps on the checkbox");
        checkbox.check(matches(isDisplayed()));
        checkbox.perform(click());
    }

    public static void assertChecked(ViewInteraction checkbox) {
//        Allure.step("Checkbox is checked");
        checkbox.check(matches(isDisplayed()));
        checkbox.check(matches(isChecked()));
    }

    public static void assertNotChecked(ViewInteraction checkbox) {
//        Allure.step("Checkbox is unchecked");
        checkbox.check(matches(isDisplayed()));
        checkbox.check(matches(isNotChecked()));
    }
}
