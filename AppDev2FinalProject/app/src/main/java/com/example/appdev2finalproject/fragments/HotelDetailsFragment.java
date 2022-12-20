package com.example.appdev2finalproject.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdev2finalproject.Hotel.BookHotel;
import com.example.appdev2finalproject.Hotel.HotelDetails;
import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;

public class HotelDetailsFragment extends Fragment {
    ImageView currentImage;
    Hotel currentHotel;
    Button bookHotel;
    View rootview;
    Hotel obj;

    public HotelDetailsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HotelDetailsFragment newInstance() {
        HotelDetailsFragment fragment = new HotelDetailsFragment();
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
        rootview = inflater.inflate(R.layout.fragment_hotel_details, container, false);

        currentHotel = obj;
        //current hotel image
        currentImage = (ImageView) rootview.findViewById(R.id.hotelDetailsImg);
        setHotelImg(currentHotel.name);

        //set name
        //current hotel name
        TextView textViewCurrentHotel = rootview.findViewById(R.id.hotelDetailsName);
        textViewCurrentHotel.setText(currentHotel.name);

        //current hotel Description
        setHotelDesc();

        bookHotel = rootview.findViewById(R.id.bookHotelBtn);

        bookHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookHotelFragment bookHotelFragment = new BookHotelFragment();
                Bundle args = new Bundle();
                args.putSerializable("hotelInfo", currentHotel);
                bookHotelFragment.setArguments(args);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, bookHotelFragment).commit();
            }
        });

        return rootview;
    }

    private void setHotelDesc() {
        TextView hotelDesc = rootview.findViewById(R.id.hoteilDetailsDesc);
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