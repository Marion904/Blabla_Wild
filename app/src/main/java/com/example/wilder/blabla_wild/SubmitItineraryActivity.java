package com.example.wilder.blabla_wild;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SubmitItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);


        final EditText submit_depart = (EditText) findViewById(R.id.submit_depart);
        final EditText submit_destination = (EditText) findViewById(R.id.submit_destination);
        final EditText submit_price = (EditText) findViewById(R.id.submit_price);
        final EditText submit_date = (EditText) findViewById(R.id.submit_date);
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
                submit_date.setText(sdf.format(myCalendar.getTime()));
            }
        };

        submit_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SubmitItineraryActivity.this, dDay, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        final EditText submit_hour = (EditText) findViewById(R.id.submit_hour);
        Button submit_trip = (Button) findViewById(R.id.submit_trip);



        submit_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (submit_depart.length() == 0 || submit_date.length() == 0||submit_destination.length()==0||submit_price.length()==0){
                    Toast.makeText(SubmitItineraryActivity.this, getString(R.string.toast_submit), Toast.LENGTH_SHORT).show();
                }else{


                    String departure = submit_depart.getText().toString();
                    String destination = submit_destination.getText().toString();
                    Date date = new Date(submit_date.getText().toString());
                    int price= new Integer (submit_price.getText().toString());
                   ItineraryModel trip = new ItineraryModel(date,price,departure,destination);


                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("itineraries");


                    myRef.push().setValue(trip);



                    /**DatabaseReference postsRef = ref.child("posts");

                     DatabaseReference newPostRef = postsRef.push();
                     newPostRef.setValue(new Post("gracehop", "Announcing COBOL, a New Programming Language"));

                     // We can also chain the two calls together
                     postsRef.push().setValue(new Post("alanisawesome", "The Turing Machine"));
                    */
                     Toast.makeText(SubmitItineraryActivity.this, getString(R.string.toast_trip), Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}
