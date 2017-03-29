package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private Button disconnect;
    private Button submitTrip;
    private Button searchTrip;

    private TextView userName;
    private TextView userEmail;
    private ImageView userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //initializing Firebase authentification objects
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, SignInActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String uName = user.getDisplayName();
        String uEmail =user.getEmail();

        disconnect = (Button) findViewById(R.id.buttonDisconnect);
        submitTrip=(Button) findViewById(R.id.buttonSubmitTrip);
        searchTrip=(Button) findViewById(R.id.buttonSearchTrip);

        disconnect.setOnClickListener(this);
        submitTrip.setOnClickListener(this);
        searchTrip.setOnClickListener(this);

        userEmail= (TextView) findViewById(R.id.textViewDisplayEmail);
        userName=(TextView) findViewById(R.id.textViewDisplayName);

        userName.setText(uName);
        userEmail.setText(uEmail);


    }

    @Override
    public void onClick(View v) {
        if (v==disconnect){
            firebaseAuth.signOut();
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(getApplicationContext(), SignInActivity.class));
        }
        if(v==searchTrip){
            Intent intent_travel = new Intent(AccountActivity.this, SearchItineraryActivity.class);
            startActivity(intent_travel);
        }if(v==submitTrip){
            Intent intent_travel = new Intent(AccountActivity.this, SubmitItineraryActivity.class);
            startActivity(intent_travel);
        }

    }
}
