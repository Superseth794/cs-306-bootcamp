package com.github.superseth794.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import android.app.Activity;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GreetingsActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void nameReceivedShouldBeDisplayed() {
        Intent myIntent = new Intent(ApplicationProvider.getApplicationContext(), GreetingsActivity.class);
        myIntent.putExtra("name", "Hugo");
        ActivityScenario<Activity> scenario = ActivityScenario.launch(myIntent);
        ViewInteraction label = onView(ViewMatchers.withId(R.id.greetingsLabel));
        label.check(matches(ViewMatchers.withText("Hello Hugo!")));
        scenario.close();
    }
}
