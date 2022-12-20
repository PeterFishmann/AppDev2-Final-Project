package com.example.appdev2finalproject.fragments;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;


public class BookHotelFragment extends Fragment {

    ImageView currentImage;
    Hotel currentHotel;
    Button bookHotel;
    Spinner mspin;
    EditText creditCard, cvv, cardName, expDate;
    View rootview;



    public BookHotelFragment() {

    }

    // TODO: Rename and change types and number of parameters
    public static BookHotelFragment newInstance() {
        BookHotelFragment fragment = new BookHotelFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            currentHotel = (Hotel) args.getSerializable("hotelInfo");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_book_hotel, container, false);
        setHotelDesc();
        setPrice();

        //dropdown numbers fill
        mspin = rootview.findViewById(R.id.spinner);
        Integer[] items = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_spinner_item, items);
        mspin.setAdapter(adapter);

        //get data from user
        creditCard = rootview.findViewById(R.id.creditCard);
        cvv = rootview.findViewById(R.id.cvv);
        cardName = rootview.findViewById(R.id.cardName);
        expDate = rootview.findViewById(R.id.expDate);

        //process the data and use it?
        return rootview;
    }

    private void setPrice() {
    }

    private void setHotelDesc() {
    }
}