package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;



/**
 * Created by Mahesh Gaya on 12/27/16.
 */
@RunWith(AndroidJUnit4.class)
public class ShowJokeButtonTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldNotBeNull() throws Exception{
        //check to see if there is an instances of fragment
        assertNotNull(R.id.fragment);
        //then performs a button click
        onView(withId(R.id.show_joke_btn)).perform(click());
        //check for errors
        assertNotEquals("Connection refused", RetrieveJokeTask.mJoke);
        assertNotEquals("Connection timeout", RetrieveJokeTask.mJoke);
        //check if it is not null
        assertNotNull(RetrieveJokeTask.mJoke);

    }
}
