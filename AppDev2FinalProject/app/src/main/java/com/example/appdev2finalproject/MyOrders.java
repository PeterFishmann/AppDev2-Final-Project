package com.example.appdev2finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.appdev2finalproject.fragments.EditAccount;

public class MyOrders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
    }

    public void goToAccount(View view){
//        navigationView.setCheckedItem(R.id.nav_dashboard);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditAccount()).commit();
    }
}