package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button start_button;
    private Button submit_button;
    private TextView account_textView;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private TextView welcome_textView;
    private String welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome_textView=(TextView) findViewById(R.id.welcome);
        welcome_textView.setText(welcome);


        start_button = (Button) findViewById(R.id.button_start);
        submit_button=(Button) findViewById(R.id.submit_button);
        account_textView = (TextView) findViewById(R.id.account);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Insert the intent linked to the starting button
        start_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_travel = new Intent(MainActivity.this, SearchItineraryActivity.class);
                startActivity(intent_travel);
            }
        });

        submit_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_submit=new Intent(MainActivity.this, SubmitItineraryActivity.class);
                startActivity(intent_submit);
            }
        });

        account_textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_account=new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent_account);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {



                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        //firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authStateListener != null) {
     //       firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }
}
//content_main.xml : tools:context="com.example.wilder.blabla_wild.fr.wcs.BlablaWild.MainActivity"