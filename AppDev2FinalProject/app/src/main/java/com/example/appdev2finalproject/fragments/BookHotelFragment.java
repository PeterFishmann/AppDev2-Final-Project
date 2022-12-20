package com.example.appdev2finalproject.fragments;

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
import android.widget.TextView;

import com.example.appdev2finalproject.R;
import com.example.appdev2finalproject.pogo.Hotel;


public class BookHotelFragment extends Fragment {

    ImageView currentImage;
    Hotel currentHotel;
    Button bookHotel;
    Spinner mspin;
    EditText creditCard, cvv, cardName, expDate;
    View rootview;
    Hotel obj;

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
            obj = (Hotel) args.getSerializable("hotelInfo");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_book_hotel, container, false);

        currentHotel = obj;
        currentImage = (ImageView) rootview.findViewById(R.id.imageView);
        setHotelImg(currentHotel.name);

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
        setHotelDesc();
        setPrice();
        bookHotel = rootview.findViewById(R.id.bookHotel2);
        String numOfDays = mspin.getSelectedItem().toString();
        bookHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyOrders myOrders = new MyOrders();
                Bundle args = new Bundle();
                currentHotel.numOfDays = numOfDays;
                args.putSerializable("hotelInfo", currentHotel);
                myOrders.setArguments(args);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, myOrders).commit();
            }
        });
        return rootview;
    }

    private void setPrice() {
    }

    private void setHotelDesc() {
        TextView hotelDesc = rootview.findViewById(R.id.hotelDetail);
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