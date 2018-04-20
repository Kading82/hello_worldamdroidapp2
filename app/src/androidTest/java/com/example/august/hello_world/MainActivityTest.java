package com.example.august.hello_world;

import android.widget.EditText;

import org.junit.Test;

import static android.provider.ContactsContract.Directory.PACKAGE_NAME;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {



    //public void verifyMessageSentToMessageActivity() {
      //  Username = (EditText) findViewById(R.id.editText3);
        // Types a message into a EditText element.
      //  onView(withId(R.id.editText3))
           //     .perform(typeText(), closeSoftKeyboard());

        // Clicks a button to send the message to another
        // activity through an explicit intent.
      //  onView(withId(R.id.send_message)).perform(click());

        // Verifies that the DisplayMessageActivity received an intent
        // with the correct package name and message.
       // intended(allOf(
          //      hasComponent(hasShortClassName(".DisplayMessageActivity")),
           //     toPackage(PACKAGE_NAME),
            //    hasExtra(MainActivity.EXTRA_MESSAGE, MESSAGE)));

    }
