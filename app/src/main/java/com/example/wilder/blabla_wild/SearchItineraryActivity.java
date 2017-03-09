package com.example.wilder.blabla_wild;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class SearchItineraryActivity extends AppCompatActivity {
  /*
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        }}*/

    Button search_button;
    EditText depart;
    EditText destination;
    EditText date;
    public final static String EXTRA_SEARCH = "journey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);
        search_button = (Button) findViewById(R.id.search_button);
        depart = (EditText) findViewById(R.id.editText);
        destination = (EditText) findViewById(R.id.editText2);

        //Open the DatepickerDialog

        date = (EditText) findViewById(R.id.editText3);
        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener dDay = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
            private void updateLabel() {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
                date.setText(sdf.format(myCalendar.getTime()));
            }
        };

        date.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchItineraryActivity.this, dDay, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //Listen to the click activity on the button
        search_button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Check that a departing and arriving point are completed
                if (depart.length() == 0 || destination.length() == 0) {
                    Toast.makeText(SearchItineraryActivity.this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
                } else {
                    //The intent to target the next activity
                    Intent intent_search = new Intent(SearchItineraryActivity.this, ViewSearchActivityResult2.class);
                    //The information we want to take from the present activity to insert on the actual visual
                    // The departure
                    String departure = depart.getText().toString();
                    String destinations = destination.getText().toString();
                    String dday = date.getText().toString();
                    SearchRequestModel searchRequestModel = new SearchRequestModel(departure, destinations, dday);
                    intent_search.putExtra(EXTRA_SEARCH, searchRequestModel);
                    startActivity(intent_search);
                }

            }
        });
    }
}


