package com.example.wilder.blabla_wild;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SearchItineraryActivity extends AppCompatActivity {


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
        depart =(EditText) findViewById(R.id.editText);
        destination =(EditText) findViewById(R.id.editText2);
        date =(EditText) findViewById(R.id.editText3);
        //Listen to the click activity on the button
        search_button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Check that a departing and arriving point are completed
                //IF YOU WANT TO CHECK THE DATE TOO IT STARTS HERE
                if (depart.length() == 0 || destination.length() == 0) {
                    Toast.makeText(SearchItineraryActivity.this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
                } else {
                    //The intent to target the next activity
                    Intent intent_search = new Intent(SearchItineraryActivity.this, ViewSearchActivityResult2.class);
                    //The information we want to take from the present activity to insert on the actual visual
                    // The departure
                    String departure = depart.getText().toString();
                    String destinations = destination.getText().toString();
                    String dday =date.getText().toString();
                    SearchRequestModel searchRequestModel = new SearchRequestModel(departure,destinations,dday);
                    intent_search.putExtra(EXTRA_SEARCH,searchRequestModel);
                    startActivity(intent_search);
                }

            }
        });
    }


}
