package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSearchActivityResult2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_result2);
        //We "getIntent" to recover the sent data
        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchItineraryActivity.message);
        //We insert the data in a TextView
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        //We precise that we want the information to be displayed the title of our activity
        setTitle(message);

    }
}



/**
 * Created by wilder on 27/02/17.
 * for he record : tha title need a textView, a plain string did not work (message had to be converted)
 * /*

 */




