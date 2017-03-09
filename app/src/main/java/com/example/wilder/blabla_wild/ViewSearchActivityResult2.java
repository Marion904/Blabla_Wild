package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
        if(result.getDate().length()==0){
            Toast.makeText(this,getString(R.string.noday),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,getString(R.string.dday)+result.getDate(),Toast.LENGTH_SHORT).show();
        }

        // Setup the data source
        ArrayList<TripResultModel> tripResultModelArrayList=new ArrayList<>(); // calls function to get items list

       
        //As proposed by the quest
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            tripResultModelArrayList.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            tripResultModelArrayList.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            tripResultModelArrayList.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            tripResultModelArrayList.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }

        //Instantiate the customListAdapter
        TripsListAdapter adapter = new TripsListAdapter(ViewSearchActivityResult2.this,tripResultModelArrayList);

        //get the ListView and attach the adpater :
        ListView listTrip = (ListView) findViewById(R.id.listViewResult);
        listTrip.setAdapter(adapter);



    }



}







