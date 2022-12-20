package com.example.appdev2finalproject.Hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appdev2finalproject.MyOrders;
import com.example.appdev2finalproject.NotificationView;
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


        //Notification for confirm purchase button
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification",
                    " My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        //confirm the hotel, and save data such as hotel names, img, days in db. Head to My orders page
        bookHotel = findViewById(R.id.button);
        bookHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotification();
            }

            private void addNotification() {
                //call the notification builder class to build the notification messages
                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(BookHotel.this, "Notification");
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setAutoCancel(true);

                Intent notificationIntent = new Intent(BookHotel.this, NotificationView.class);

                //PendingIntent is the called Intent activity until the user performs an action
                PendingIntent contentIntent = PendingIntent.getActivity(BookHotel.this, 0,
                        notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);

                // Call the manager to add the messages as Notification

                NotificationManager manager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, builder.build());

                Intent switchActivity = new Intent(BookHotel.this, MyOrders.class);
                switchActivity.putExtra("hotelInfo", currentHotel);
                startActivity(switchActivity);

            }
        });


        //dropdown numbers fill
        mspin = findViewById(R.id.spinner);
        Integer[] items = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
//        for(int i = 0; i<=32; i++){
//            items[i] = i + 1;
//        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, items);
        mspin.setAdapter(adapter);

        //get data from user
        creditCard = findViewById(R.id.creditCard);
        cvv = findViewById(R.id.cvv);
        cardName = findViewById(R.id.cardName);
        expDate = findViewById(R.id.expDate);

        //process the data and use it?

        //change price based on dropdown

    }


}