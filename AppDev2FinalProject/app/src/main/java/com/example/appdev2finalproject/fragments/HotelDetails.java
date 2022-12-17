package com.example.appdev2finalproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appdev2finalproject.R;

public class HotelDetails extends Fragment {



    public HotelDetails() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HotelDetails newInstance(String param1, String param2) {
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