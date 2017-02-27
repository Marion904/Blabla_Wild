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
    String announce;
    static String message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);
        search_button = (Button) findViewById(R.id.search_button);
        depart =(EditText) findViewById(R.id.editText);
        destination =(EditText) findViewById(R.id.editText2);
        announce = getString(R.string.announce);

        //Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        //TextView textView = new TextView(this);
        //textView.setTextSize(40);
        //textView.setText(message);
        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_search_itinerary);
        //layout.addView(textView);

        search_button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                if (depart.length() == 0 || destination.length() == 0) {
                    Toast.makeText(SearchItineraryActivity.this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent_search = new Intent(SearchItineraryActivity.this, ViewSearchActivityResult2.class);

                    String trajet = announce+" "+depart.getText().toString()+" - "+ destination.getText().toString();
                    intent_search.putExtra(message, trajet);
                    startActivity(intent_search);



                }

            }
        });
    }
    /*
    public static class ViewSearchItineraryResultListActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_view_search_itinerary_result_list);

            Intent intent = getIntent();
            String message = intent.getStringExtra(EXTRA_MESSAGE);
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(message);

            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_view_search_itinerary_result_list);
            layout.addView(textView);

        }
     */

}
