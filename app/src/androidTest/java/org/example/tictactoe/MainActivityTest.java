package org.example.tictactoe;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureAboutButtonWorks() {
        // Click the About button
        onView(withId(R.id.about_button)).perform(click());

        // Check that the dialog is displayed
        onView(withText(R.string.about_title)).check(matches(isDisplayed()));

        // Click OK button
        onView(withId(android.R.id.button1)).perform(click());

        // Check that dialog is no longer displayed
        onView(withText(R.string.about_title)).check(doesNotExist());
    }

    @Test
    public void ensureNewGameButtonWorks() {
        // Click the New Game button
        onView(withId(R.id.new_button)).perform(click());

        // Check that a new game board is displayed
        onView(withText(R.id.fragment_game)).check(matches(isDisplayed()));
    }
}