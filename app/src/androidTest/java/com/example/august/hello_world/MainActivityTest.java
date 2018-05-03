package com.example.august.hello_world;

import android.support.test.espresso.contrib.PickerActions;
import android.support.test.rule.ActivityTestRule;
import android.widget.DatePicker;
import android.widget.EditText;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import android.support.test.runner.AndroidJUnit4;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {

        onView(withId(datePickerLaunchViewId)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));

        onView(withId(android.R.id.button1)).perform(click());

    }

    @Test
    public void testtextandforms() {
        onView(withText("Submit")).perform(click());
        onView(withText(R.string.alert))
                .check(matches(isDisplayed()));
        onView(withId(R.id.editText))
                .perform(typeText("Poophaha"), closeSoftKeyboard());
        onView(withId(R.id.editText2))
                .perform(typeText("Poophaha"), closeSoftKeyboard());
        onView(withId(R.id.editText3))
                .perform(typeText("Poophaha"), closeSoftKeyboard());
        onView(withId(R.id.editText4))
                .perform(typeText("14"), closeSoftKeyboard());

        setDate(R.id.editText5, 1994, 1, 1);

        onView(withText("Submit")).perform(click());

        onView(withId(R.id.textviewtab3))
                .check(matches(withText("Email: Poophaha")));
        onView(withId(R.id.textviewtab2))
                .check(matches(withText("Name: Poophaha")));
        onView(withId(R.id.textviewtab1))
                .check(matches(withText("Thanks for Signing Up Poophaha!")));
        onView(withId(R.id.textviewtab4))
                .check(matches(withText("Birthday: 0/1/1994")));
        onView(withId(R.id.textviewtab5))
                .check(matches(withText("Age: 14")));


    }

    }
