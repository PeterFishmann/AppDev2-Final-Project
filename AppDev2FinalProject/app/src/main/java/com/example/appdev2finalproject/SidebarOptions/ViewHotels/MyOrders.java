package com.example.appdev2finalproject.SidebarOptions.ViewHotels;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;

public class MyOrders extends Fragment {

    ImageView currentImage;
    Hotel currentHotel;
    Button cancel;
    View rootview;
    Hotel obj;
    TextView hotelDesc;

    public MyOrders() {
        // Required empty public constructor
    }

    public static MyOrders newInstance(String param1, String param2) {
        MyOrders fragment = new MyOrders();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            obj = (Hotel) args.getSerializable("hotelInfo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_my_orders, container, false);

        //set image
        currentHotel = obj;
        currentImage = (ImageView) rootview.findViewById(R.id.myFlightHotelImg);
        setHotelImg(currentHotel.name);

        //set desc and days
        setHotelDesc();
        setDays();
        cancel = rootview.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayout firstHotel = rootview.findViewById(R.id.firstHotel);
                ViewGroup parent = (ViewGroup) firstHotel.getParent();
                parent.removeView(firstHotel);
            }
        });

        return rootview;
    }

    private void setDays() {
        TextView numOfDays = rootview.findViewById(R.id.numOfDays);
        String msg = currentHotel.numOfDays;
        numOfDays.setText(msg);
    }

    private void setHotelDesc() {
        hotelDesc = rootview.findViewById(R.id.myFlightsHotelDesc);
        String info = currentHotel.hotelDesc;
        String msg = "\"" + info + "\"";
        hotelDesc.setText(msg);
    }

    private void setHotelImg(String name) {
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