package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewSearchResult2Activity extends AppCompatActivity {

    private String departure;
    private String destination;
    private DatabaseReference mTripDataBase;

    private ListView tripResult;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_result2);

        // Make sure we have a Departure and a Destination
        //We "getIntent" to recover the sent data
        Intent intent = getIntent();
        //Creation of the final string
        SearchRequestModel result = intent.getParcelableExtra(SearchItineraryActivity.EXTRA_SEARCH);
        if (result.getDate().length() == 0) {
            Toast.makeText(this, getString(R.string.noday), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.dday) + result.getDate(), Toast.LENGTH_SHORT).show();
        }
        //We precise that we want the information to be displayed in the title of our activity
        departure = result.getDepart();
        destination = result.getDestination();
        setTitle(departure + getString(R.string.arrow) + destination);



        /**ListView**/
        tripResult= (ListView) this.findViewById(R.id.listViewResult);

        mTripDataBase = FirebaseDatabase.getInstance().getReference("itineraries");//Appel à la base de données

        TripsListAdapter tripsListAdapter = new TripsListAdapter(mTripDataBase, this, R.layout.trip_item);

        tripResult.setAdapter(tripsListAdapter);

    }

}














