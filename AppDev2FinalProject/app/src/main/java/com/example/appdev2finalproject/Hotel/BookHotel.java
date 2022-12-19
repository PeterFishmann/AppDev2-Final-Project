package com.example.appdev2finalproject.Hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;

public class BookHotel extends AppCompatActivity {
    ImageView currentImage;
    Hotel currentHotel;
    Button bookHotel;
    Spinner mspin;
    EditText creditCard, cvv, cardName, expDate;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_hotel);
        currentHotel = (Hotel) getIntent().getSerializableExtra("hotelInfo");

        setHotelDesc();
        setPrice();

        //dropdown numbers fill
        mspin = findViewById(R.id.spinner);
        Integer[] items = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
//        for(int i = 0; i<=32; i++){
//            items[i] = i + 1;
//        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        mspin.setAdapter(adapter);

        //get data from user
        creditCard = findViewById(R.id.creditCard);
        cvv = findViewById(R.id.cvv);
        cardName = findViewById(R.id.cardName);
        expDate = findViewById(R.id.expDate);

        //process the data and use it?

        //confirm the hotel, and save data such as hotel names, img, days in db. Head to My orders page
        bookHotel = findViewById(R.id.button);
        bookHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivity = new Intent(BookHotel.this, MyOrders.class);
                switchActivity.putExtra("hotelInfo", currentHotel);
                startActivity(switchActivity);
            }
        });
    }

    //change price based on dropdown
    private void setPrice() {
//        TextView hotelDesc = findViewById(R.id.hotelDetail);
//        Spinner spinner = findViewById(R.id.spinner);
//        String info = currentHotel.hotelDesc;
//        String msg = "\"" + info + "\"";
//        hotelDesc.setText(msg);
    }

    public void setHotelDesc() {
        TextView hotelDesc = findViewById(R.id.hotelDetail);
        String info = currentHotel.hotelDesc;
        String msg = "\"" + info + "\"";
        hotelDesc.setText(msg);
    }


}