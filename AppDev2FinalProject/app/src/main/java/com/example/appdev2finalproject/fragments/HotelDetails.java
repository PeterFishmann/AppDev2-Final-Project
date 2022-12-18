package com.example.appdev2finalproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;

public class HotelDetails extends Fragment {

    Hotel currentHotel;
    ImageView hotelImg;

    public HotelDetails() {

    }

    public static HotelDetails newInstance() {
        HotelDetails fragment = new HotelDetails();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_details, container, false);
    }
}