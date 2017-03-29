package com.example.wilder.blabla_wild;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button signIn;
    private EditText userMail;
    private EditText userPwd;
    private TextView newUser;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signIn = (Button) findViewById(R.id.buttonSignIn);
        userMail = (EditText) findViewById(R.id.editTextUserEmail);
        userPwd = (EditText) findViewById(R.id.editTextPwd);
        newUser = (TextView) findViewById(R.id.textViewSignUpNew);
        progressDialog = new ProgressDialog(this);

        //Create the listeners

        signIn.setOnClickListener(this);
        newUser.setOnClickListener(this);


        //initializing Firebase authentification objects
        firebaseAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //closing this activity
                    finish();
                    //starting login activity
                    startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                }
                // ...
            }

        };
    }


    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void userLogIn(){
        //getting email and password from edit texts
        String email = userMail.getText().toString().trim();
        String password  = userPwd.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(SignInActivity.this,getString(R.string.toastDefaultEmail),Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(SignInActivity.this,getString(R.string.toastDefaultPwd),Toast.LENGTH_LONG).show();
            return;
        }
        //if the email and password are not empty
        //displaying a progress dialog
        progressDialog.setMessage(getString(R.string.signInPending));
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if(task.isSuccessful()){
                            //start the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        }else{
                            Toast.makeText(getApplicationContext(),getString(R.string.signInFailed),Toast.LENGTH_SHORT);
                        }
                    }
                });
    }
    @Override
    public void onClick(View v) {
        if(v==signIn){
            userLogIn();
        }
        if(v==newUser){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, SignUpActivity.class));
        }
    }
}
