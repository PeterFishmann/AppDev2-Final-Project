package com.example.appdev2finalproject;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditAccount extends Fragment {

    // Get a LayoutInflater object
//    LayoutInflater inflater = getActivity().getLayoutInflater();
    public static final int PICK_IMAGE_REQUEST_CODE = 123;
    DatabaseReference reference;
String _FNAME, _LNAME, _EMAIL;
    ImageView photoView;
    EditText fName, lName, email;
    public EditAccount() {
        // Required empty public constructor
    }

    public static EditAccount newInstance(String param1, String param2) {
        EditAccount fragment = new EditAccount();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reference = FirebaseDatabase.getInstance().getReference("users");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_account, container, false);
        // Find the image in the layout
        photoView = rootView.findViewById(R.id.photoView);
        fName = rootView.findViewById(R.id.fName);
        lName = rootView.findViewById(R.id.lName);
        email = rootView.findViewById(R.id.email);
        Button save = rootView.findViewById(R.id.saveChanges);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveChanges(rootView);
            }
        });
//        getImage();
//        showImage(photoView);
//        updateImage();

        // Return the inflated layout
        return rootView;
    }

    private void saveChanges(View rootView) {

        if(isNameChanged() || isLnameChanged() || isEmailChanged()){
            Toast.makeText(getActivity(), "Data has been updated", Toast.LENGTH_SHORT).show();
        }

//        return rootView;
    }

    private boolean isEmailChanged() {
    }

    private boolean isLnameChanged() {
    }

    private boolean isNameChanged() {
        if(!_FNAME.equals(fName.getText().toString())){

            return true;
        }else {
            return false;
        }
    }

    private void getImage() {

        // Create an Intent with the ACTION_PICK action
        Intent intent = new Intent(Intent.ACTION_PICK);

// Set the type of data that the intent will retrieve to image/*
        intent.setType("image/*");

// Start the activity and wait for a result
        startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);

    }

    private void showImage(ImageView photoView) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


// Get the user's photo URL
        Uri photoUrl = user.getPhotoUrl();

// Display the user's photo in an ImageView

        Glide.with(this)
                .load(photoUrl)
                .into(photoView);
    }

    private void updateImage() {
        //get the picture and load it
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // Get the user's profile photo URL
        String photoUrl = "https://wompampsupport.azureedge.net/fetchimage?siteId=7575&v=2&jpgQuality=100&width=700&url=https%3A%2F%2Fi.kym-cdn.com%2Fentries%2Ficons%2Ffacebook%2F000%2F004%2F815%2Flologuy.jpg";

        // Build the update object
        UserProfileChangeRequest update = new UserProfileChangeRequest.Builder()
                .setPhotoUri(Uri.parse(photoUrl))
                .build();

        // Apply the update
        user.updateProfile(update)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // The user's profile photo has been updated
                            Toast.makeText(getActivity(), "Photo imported", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        View rootView = getView();
        // Check if the request code matches the one we use for selecting an image
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // Get the URI of the selected image
            Uri imageUri = data.getData();

            // Set the image to the ImageView

//            rootView.findViewById(R.id.photoView).setImageURI(imageUri);
        }
    }

}