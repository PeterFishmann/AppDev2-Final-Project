package com.example.appdev2finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button bookHotels, viewAccount, viewWallet, createListing, myListings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

//        bookHotels = findViewById(R.id.buttonHotel);
//        viewAccount = findViewById(R.id.buttonAccount);
//        viewWallet = findViewById(R.id.buttonWallet);
//        createListing = findViewById(R.id.buttonCreateListing);
//        myListings = findViewById(R.id.buttonMyListings);
//
//        bookHotels.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainMenu.this, BookHotels.class));
//            }
//        });
//
//        viewAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainMenu.this, ViewAccount.class));
//            }
//        });
//
//        viewWallet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainMenu.this, ViewWallet.class));
//            }
//        });
//
//        createListing.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainMenu.this, CreateListing.class));
//            }
//        });
//
//        myListings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainMenu.this, MyListings.class));
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}