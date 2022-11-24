package com.example.appdev2finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    ArrayList<String> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loadMenus();
    }

    private void loadMenus() {
        menuList = new ArrayList<>(Arrays.asList("Book Hotels", "View account", "View Wallet",
                "Create Listing", "My Listings"));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DashboardAdapter adapter = new DashboardAdapter(menuList, Dashboard.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.VERTICAL, false));
    }
}