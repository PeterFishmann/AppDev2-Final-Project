package com.example.appdev2finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdev2finalproject.pogo.Hotel;

public class HotelDetails extends AppCompatActivity {
    ImageView currentImage;
    Hotel currentHotel;

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
    }

    private void setHotelDesc() {
        TextView hotelDesc = findViewById(R.id.hoteilDetailsDesc);
        String info = currentHotel.hotelDesc;
        String msg = "\"" + info + "\"";
        hotelDesc.setText(msg);
    }

    private void setPizzaImg(String name) {

        switch (name) {
            case "Hotel Ai Ai":
                currentImage.setImageResource(R.drawable.aiai);
                break;
            case "Hotel Transelvannia":
                currentImage.setImageResource(R.drawable.ew);
                break;
            case "Hotel Trivago":
                currentImage.setImageResource(R.drawable.vip);
                break;
            case "Hotel Vanhorne":
                currentImage.setImageResource(R.drawable.trivago);
                break;
            case "Hotel VIP":
                currentImage.setImageResource(R.drawable.trans);
                break;
        }
    }
}