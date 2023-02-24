package com.github.superseth794.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.intent.Intents.intended;

import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void enteringNameWorks() {
        Intents.init();
        ViewInteraction name = onView(ViewMatchers.withId(R.id.mainName));
        name.perform(ViewActions.typeText("Hugo"));
        name.perform(ViewActions.closeSoftKeyboard());

        ViewInteraction goButton = onView(ViewMatchers.withId(R.id.mainGoButton));
        goButton.perform(ViewActions.click());

        intended(allOf(
                IntentMatchers.hasComponent(GreetingsActivity.class.getName()),
                IntentMatchers.hasExtra("name", "Hugo")
        ));

        Intents.release();
    }
}
