package com.example.august.hello_world;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CardContentFragment extends Fragment {

    public EditText dmrt;
    public EditText maxdis;
    public EditText mf;
    public EditText account;
    public EditText Agerng;

    public CardContentFragment() {

    }

    private static settingsTable addUser(final settingsDb db, settingsTable settingsTable) {

        db.userDao().insertId(settingsTable);
        return settingsTable;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.settings_tab, container, false);

        settingsTable user = new settingsTable();

        TextView account = view.findViewById(R.id.textViewsettings1);
        EditText drmt = view.findViewById(R.id.editText6);
        EditText maxdis = view.findViewById(R.id.editText8);
        EditText agerange = view.findViewById(R.id.editText9);
        EditText gender = view.findViewById(R.id.editText7);

      //  user.setGender("Male"); dog
      //  user.setAccountSettings("Private");
      //  user.setdMrT("25");
      //  user.setAgeRange("25-39");

        drmt.setText(user.getdMrT());
        agerange.setText(user.getAgeRange());
        gender.setText(user.getGender());

        Button btn = (Button) view.findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView account = view.findViewById(R.id.textViewsettings1);
                EditText drmt = view.findViewById(R.id.editText6);
                EditText maxdis = view.findViewById(R.id.editText8);
                EditText agerange = view.findViewById(R.id.editText9);
                EditText gender = view.findViewById(R.id.editText7);

                String accountpass = account.getText().toString();
                String drmtpass = drmt.getText().toString();
                String maxdispass = maxdis.getText().toString();
                String agerangepass = agerange.getText().toString();
                String genderpass = gender.getText().toString();

                settingsTable user = new settingsTable();
                user.setGender("Gender: " + genderpass);
                user.setAgeRange("Age Range: " + agerangepass);
                user.setdMrT("Dis: " + maxdispass);

                Toast.makeText(v.getContext(), "Your settings have been saved.", Toast.LENGTH_SHORT).show();
            }

        });

        return view;
    }


}