package com.example.appdev2finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.appdev2finalproject.Authentication.MainActivity;
import com.example.appdev2finalproject.fragments.CreateListing;
import com.example.appdev2finalproject.fragments.EditAccount;
import com.example.appdev2finalproject.fragments.MyAccount;
import com.example.appdev2finalproject.fragments.MyListings;
import com.example.appdev2finalproject.fragments.ViewHotels;
import com.example.appdev2finalproject.fragments.ViewWalletFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables
    ArrayList<String> menuList;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        loadMenus();

        //hooks(finding variables in layout
        //the whole layout
        drawerLayout = findViewById(R.id.drawer_layout);
        //the nav view
        navigationView = findViewById(R.id.nav_view);

        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //navigation drawer menu\
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_dashboard);
    }

    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.nav_view:
//                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
//                break;
            case R.id.nav_hotels:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewHotels()).commit();
                break;
            case R.id.nav_my_account:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyAccount()).commit();
                break;
            case R.id.nav_create_listing:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CreateListing()).commit();
                break;
            case R.id.nav_my_listings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyListings()).commit();
                break;
            case R.id.nav_wallet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ViewWalletFragment()).commit();
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Dashboard.this, MainActivity.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void goToAccount(View view){
        navigationView.setCheckedItem(R.id.nav_dashboard);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EditAccount()).commit();
    }

//    public void goToHotel(View view) {
//        navigationView.setCheckedItem(R.id.nav_hotels);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HotelDetails()).commit();
//    }

//    private void loadMenus() {
//        menuList = new ArrayList<>(Arrays.asList("Book Hotels", "View account", "View Wallet",
//                "Create Listing", "My Listings"));
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        ViewHotelsAdapter adapter = new ViewHotelsAdapter(menuList, Dashboard.this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(Dashboard.this, LinearLayoutManager.VERTICAL, false));
//    }
}