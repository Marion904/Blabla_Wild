package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;




/**
 * Created by wilder on 27/02/17.
 */

public class ViewSearchItineraryResultListActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_result_list);

            Intent intent = getIntent();
            String message = intent.getStringExtra(SearchItineraryActivity.message);
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(message);

            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_search_itinerary_result_list);
            layout.addView(textView);

        }
}
