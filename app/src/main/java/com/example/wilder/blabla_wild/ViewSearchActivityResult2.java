package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewSearchActivityResult2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_result2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SearchItineraryActivity.message);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_search_result2);
        //layout.addView(textView);
        setTitle(message);

    }
}



/*
package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.wilder.blabla_wild.R;



/**
 * Created by wilder on 27/02/17.
 */



