package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewSearchActivityResult2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_result2);
        //We "getIntent" to recover the sent data
        Intent intent = getIntent();
        //Creation of the final string
        SearchRequestModel result = intent.getParcelableExtra(SearchItineraryActivity.EXTRA_SEARCH);

        //String message = intent.getStringExtra("messageDepart")+getString(R.string.string_fleche)+intent.getStringExtra("messageArrivee");

        //We precise that we want the information to be displayed the title of our activity
        setTitle(result.getDepart()+getString(R.string.arrow)+result.getDestination());
        Toast.makeText(this,getString(R.string.dday)+result.getDate(),Toast.LENGTH_SHORT).show();

    }
}







