package com.example.august.hello_world;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.AsyncTask;
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

import java.lang.ref.WeakReference;
import java.util.List;

public class CardContentFragment extends Fragment {

    public EditText dmrt;
    public EditText maxdis;
    public EditText mf;
    public EditText account;
    public EditText Agerng;

    public CardContentFragment() {

    }

    private settingsTable addUser(final settingsDb db, settingsTable settingsTable) {
        return settingsTable;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.settings_tab, container, false);

        settingsDb db = AppDatabaseSingleton.getAppDatabase(getActivity());

        TextView account = view.findViewById(R.id.textViewsettings1);
        EditText drmt = view.findViewById(R.id.editText6);
        EditText maxdis = view.findViewById(R.id.editText8);
        EditText agerange = view.findViewById(R.id.editText9);
        EditText gender = view.findViewById(R.id.editText7);

        settingsTable row = new settingsTable();
        String accountpass = account.getText().toString();
        String drmtpass = drmt.getText().toString();
        String maxdispass = maxdis.getText().toString();
        String agerangepass = agerange.getText().toString();
        String genderpass = gender.getText().toString();

        settingsTable user = new settingsTable();
        row.setGender("Gender: " + genderpass);
        row.setAgeRange("Age Range: " + agerangepass);
        row.setdMrT("Dis: " + maxdispass);

      //  user.setGender("Male"); dog
      //  user.setAccountSettings("Private");
      //  user.setdMrT("25");
      //  user.setAgeRange("25-39");

        //drmt.setText(user.getdMrT());
        //agerange.setText(user.getAgeRange());
        //gender.setText(user.getGender());

        Button btn = (Button) view.findViewById(R.id.button4);
        btn.setOnClickListener(v -> {

            TextView account1 = view.findViewById(R.id.textViewsettings1);
            EditText drmt1 = view.findViewById(R.id.editText6);
            EditText maxdis1 = view.findViewById(R.id.editText8);
            EditText agerange1 = view.findViewById(R.id.editText9);
            EditText gender1 = view.findViewById(R.id.editText7);

            row.setGender("Gender: " + genderpass);
            row.setAgeRange("Age Range: " + agerangepass);
            row.setdMrT("Dis: " + maxdispass);

            new UpdateUserTask(getActivity(), user).execute();

            Toast.makeText(v.getContext(), "Your settings have been saved.", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    // Have to do this in an Async Task (in doInBackground
    private static class UpdateUserTask extends AsyncTask<Void, Void, settingsTable> {

        private WeakReference<Activity> weakActivity;
        private settingsTable user;

        public UpdateUserTask(Activity activity, settingsTable user) {
            weakActivity = new WeakReference<>(activity);
            this.user = user;
        }

        @Override
        protected settingsTable doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if (activity == null) {
                return null;
            }

            settingsDb db = AppDatabaseSingleton.getAppDatabase(activity.getApplicationContext());
            return user;
        }

       //     @Override
       //     protected void onPostExecute(settingsTable user) {
        //        CardContentFragment activity = (CardContentFragment) weakActivity.get();
       //         if(user == null || activity == null) {
       //             return;
                }

        //    db.settingsDao().insertId(user);
         //   String[] id = {  };
//
        //    List<settingsTable> users = db.settingsDao().insertId(id);

         //   if(users.size() <= 0 || users.get(0) == null) {
         //       return null;
        //    }
         //   return users.get(0);
     //   }

        }


  //  }

