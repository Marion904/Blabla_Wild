package com.example.wilder.blabla_wild;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private StorageReference mStorageRef;
    private FirebaseAuth.AuthStateListener mAuth;

    private Button disconnect;
    private Button submitTrip;
    private Button searchTrip;

    private TextView userName;
    private TextView userEmail;
    private ImageView userProfile;


    private Uri imageUri;
    private String uId;
    private String uName;
    private String uEmail;

    private static final int PICK_PHOTO =256;
   // private String URL;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        imageUri=null;

        //initializing Firebase authentification objects
        firebaseAuth = FirebaseAuth.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference("users_avatar");

        //if the user is not logged in that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, SignInActivity.class));
        }else{
            //Retrieve user's information
            FirebaseUser user = firebaseAuth.getCurrentUser();

            uId = user.getUid();
            uName = user.getDisplayName();
            uEmail =user.getEmail();




            disconnect = (Button) findViewById(R.id.buttonDisconnect);
            submitTrip=(Button) findViewById(R.id.buttonSubmitTrip);
            searchTrip=(Button) findViewById(R.id.buttonSearchTrip);
            userProfile=(ImageView) findViewById(R.id.imageViewProfile);
            userProfile.setImageResource(android.R.color.transparent);

            //Load the Textviews :
            userEmail= (TextView) findViewById(R.id.textViewDisplayEmail);
            userName=(TextView) findViewById(R.id.textViewDisplayName);

            disconnect.setOnClickListener(this);
            submitTrip.setOnClickListener(this);
            searchTrip.setOnClickListener(this);
            userProfile.setOnClickListener(this);

            userName.setText(uName);
            userEmail.setText(uEmail);



            downloadAvatar();
            //URL = mStorageRef.child(firebaseAuth.getCurrentUser().getDisplayName()+"_avatar.jpg").getDownloadUrl().toString();
            //new ImageDownload(userProfile).execute(URL);
        }
    }




    /**
     *  // Load the image using Glide
     String downloadUrl = mStorageRef.child(firebaseAuth.getCurrentUser().getDisplayName()+"_avatar.jpg").getDownloadUrl().toString();

     try {
     Bitmap bitmapOrg = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
     userProfile.setImageBitmap(bitmapOrg);
     } catch (IOException e) {
     e.printStackTrace();
     }
     */
    private void openGallery() {
        Intent gallery = new Intent();

        gallery.setType("image/*");

        gallery.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
        if (resultCode == RESULT_OK && requestCode == PICK_PHOTO) {
            imageUri = data.getData();

            uploadAvatar(imageUri);
            downloadAvatar();

        }
    }

    private void uploadAvatar(Uri uri){

        StorageReference usersPic = mStorageRef.child(firebaseAuth.getCurrentUser().getDisplayName()+"_avatar.jpg");
        usersPic.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Uri downloadUrl = taskSnapshot.getDownloadUrl();

                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                .setPhotoUri(downloadUrl)
                                .build();
                        firebaseAuth.getCurrentUser().updateProfile(profileUpdates);
                        downloadAvatar();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AccountActivity.this,R.string.uriDownloadFail,Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void downloadAvatar(){
        StorageReference usersPic = mStorageRef.child(firebaseAuth.getCurrentUser().getDisplayName()+"_avatar.jpg");
        usersPic.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(AccountActivity.this)
                        .load(uri)
                        .into(userProfile);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(AccountActivity.this,R.string.uriDownloadFail,Toast.LENGTH_SHORT).show();
            }
        });

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
        }
        if(v==submitTrip){
            Intent intent_travel = new Intent(AccountActivity.this, SubmitItineraryActivity.class);
            startActivity(intent_travel);
        }
        if(v==userProfile){
            openGallery();
        }

    }

}


