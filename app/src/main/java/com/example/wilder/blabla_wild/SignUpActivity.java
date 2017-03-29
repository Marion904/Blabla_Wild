package com.example.wilder.blabla_wild;

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

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuth;
    private Button signUp;
    private EditText userEmail;
    private EditText userPwd;
    private EditText userName;
    private TextView signIn;
    //private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Create Instance
        firebaseAuth = FirebaseAuth.getInstance();

        signUp =(Button) findViewById(R.id.buttonSignUp);
        signUp.setOnClickListener(this);
        signIn=(TextView) findViewById(R.id.textViewSignInOld);
        signIn.setOnClickListener(this);

        userEmail=(EditText) findViewById(R.id.editTextNewUserEmail);
        userName=(EditText) findViewById(R.id.editTextUserDisplayName);
        userPwd=(EditText) findViewById(R.id.editTextNewPwd);

       // progressDialog= new ProgressDialog(this);

        mAuth= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user !=null){
                    finish();
                    startActivity(new Intent(SignUpActivity.this, AccountActivity.class));
                }
            }
        };
    }
    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuth);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuth != null) {
            firebaseAuth.removeAuthStateListener(mAuth);
        }
    }
    public void registerUser(){
        //getting email and password from edit texts
        String email = userEmail.getText().toString().trim();
        String password  = userPwd.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(SignUpActivity.this,getString(R.string.toastDefaultEmail),Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(SignUpActivity.this,getString(R.string.toastDefaultPwd),Toast.LENGTH_LONG).show();
            return;
        }
        //if the email and password are not empty
        /**displaying a progress dialog
        progressDialog.setMessage(getString(R.string.signUpPending));
        progressDialog.show();
         **/

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUpActivity.this, R.string.auth_succeeded,Toast.LENGTH_SHORT).show();

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, R.string.auth_failed,Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }

    @Override
    public void onClick(View v) {
        if(v==signUp){
            registerUser();
        }
        if(v==signIn){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, SignUpActivity.class));
        }
    }
}
