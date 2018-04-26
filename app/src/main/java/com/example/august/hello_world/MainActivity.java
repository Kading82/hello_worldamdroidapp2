package com.example.august.hello_world;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.august.hello_world.R.string.alert;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE = "pass1";
    public static String EXTRA_MESSAGE2 = "pass2";
    public static String EXTRA_MESSAGE3 = "pass3";
    public static String EXTRA_MESSAGE4 = "pass4";
    public static String EXTRA_MESSAGE5 = "pass5";
    DatePickerDialog datePickerDialog;
    private EditText Name;
    private EditText Email;
    private EditText Username;
    private EditText DOB;
    private EditText Age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DOB = (EditText) findViewById(R.id.editText5);
        // perform click event on edit text
        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Dialog,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                // set day of month , month and year value in the edit text
                                DOB.setText(month + "/" + day + "/" + year);
                                Calendar userAge = new GregorianCalendar(year,month,day);
                                Calendar minAdultAge = new GregorianCalendar();
                                minAdultAge.add(Calendar.YEAR, -18);
                                if (minAdultAge.before(userAge)) {
                                    Snackbar.make(findViewById(R.id.editText5), "You must be at least 18 years or older, the application will now close",
                                            Snackbar.LENGTH_SHORT)
                                            .show();
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            finish();
                                        }
                                    }, 5000); // Millisecond 1000 = 1 sec


                                }

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    //Button call and retrieve username and pass username to second actvity
    public void onButtonClick(View v) {

        Name = (EditText) findViewById(R.id.editText);
        Email = (EditText) findViewById(R.id.editText2);
        Username = (EditText) findViewById(R.id.editText3);
        Age = (EditText) findViewById(R.id.editText4);
        DOB = (EditText) findViewById(R.id.editText5);

        boolean checkFormat;


        if (Name.length() == 0 || Email.length() == 0 || Username.length() == 0
                || Age.length() == 0  || DOB.length() == 0) {
            Snackbar.make(findViewById(R.id.editText), R.string.alert,
                    Snackbar.LENGTH_SHORT)
                    .show();
            return;
        }

        if (Age.length() > 2){
            Snackbar.make(findViewById(R.id.editText), "No one over 99 should be dating",
                    Snackbar.LENGTH_SHORT)
                    .show();
            return;
        }


        Intent intent = new Intent(this, Main2Activity.class);
        Bundle extras = new Bundle();
        String message = Username.getText().toString();
        String message2 = Name.getText().toString();
        String message3 = Email.getText().toString();
        String message4 = DOB.getText().toString();
        String message5 = Age.getText().toString();
        extras.putString(EXTRA_MESSAGE, message);
        extras.putString(EXTRA_MESSAGE2, message2);
        extras.putString(EXTRA_MESSAGE3, message3);
        extras.putString(EXTRA_MESSAGE4, message4);
        extras.putString(EXTRA_MESSAGE5, message5);
        intent.putExtras(extras);
        startActivity(intent);
    }
}








