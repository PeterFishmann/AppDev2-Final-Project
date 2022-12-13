package com.example.appdev2finalproject;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.bumptech.glide.Glide;

public class EditAccount extends Fragment {

    public EditAccount() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EditAccount newInstance(String param1, String param2) {
        EditAccount fragment = new EditAccount();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    updateImage();
        showImage();
    }

    private void updateImage() {
        //get the picture and load it
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // Get the user's profile photo URL
        String photoUrl = "http://www.example.com/my_photo.jpg";

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
                        }
                    }
                });
    }

    private void showImage() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        View rootView = getView();

// Get the user's photo URL
        Uri photoUrl = user.getPhotoUrl();

// Display the user's photo in an ImageView
        ImageView photoView = rootView.findViewById(R.id.photoView);
        Glide.with(this)
                .load(photoUrl)
                .into(photoView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_account, container, false);
    }
}