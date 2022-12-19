package com.example.appdev2finalproject.Hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;

public class HotelDetails extends AppCompatActivity {
    ImageView currentImage;
    Hotel currentHotel;
    Button bookHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);
        currentHotel = (Hotel) getIntent().getSerializableExtra("hotelInfo");

        //current hotel name
        TextView textViewCurrentHotel = findViewById(R.id.hotelDetailsName);
        textViewCurrentHotel.setText(currentHotel.name);

        //current hotel image
        currentImage = (ImageView) findViewById(R.id.hotelDetailsImg);
        setPizzaImg(currentHotel.name);

        //current hotel Description
        setHotelDesc();

        bookHotel = findViewById(R.id.bookHotelBtn);

        bookHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivity = new Intent(HotelDetails.this, BookHotel.class);
                switchActivity.putExtra("hotelInfo", currentHotel);
                startActivity(switchActivity);
            }
        });
    }

    public void setHotelDesc() {
        TextView hotelDesc = findViewById(R.id.hoteilDetailsDesc);
        String info = currentHotel.hotelDesc;
        String msg = "\"" + info + "\"";
        hotelDesc.setText(msg);
    }

    public void setPizzaImg(String name) {

        switch (name) {
            case "Hotel Ai Ai":
                currentImage.setImageResource(R.drawable.aiai);
                break;
            case "Hotel Transelvannia":
                currentImage.setImageResource(R.drawable.trans);
                break;
            case "Hotel Trivago":
                currentImage.setImageResource(R.drawable.trivago);
                break;
            case "Hotel Vanhorne":
                currentImage.setImageResource(R.drawable.ew);
                break;
            case "Hotel VIP":
                currentImage.setImageResource(R.drawable.vip);
                break;
        }
    }


}