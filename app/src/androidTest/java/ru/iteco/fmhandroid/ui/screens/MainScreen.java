package ru.iteco.fmhandroid.ui.screens;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.auxiliaries.CustomViewMatcher.waitUntilDisplayed;

import ru.iteco.fmhandroid.R;

public class MainScreen {

    private final int viewID = R.id.all_news_text_view;
    public void waitUntilIsDisplayed () {
        onView(isRoot()).perform(waitUntilDisplayed(viewID, 5000));
    }
}
