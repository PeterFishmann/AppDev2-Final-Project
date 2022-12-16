package com.example.appdev2finalproject.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appdev2finalproject.adapters.ViewHotelsAdapter;
import com.example.appdev2finalproject.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewHotels extends Fragment {
    RecyclerView recyclerView;
    public int[] imageUrls;

    public ViewHotels() {
        // Required empty public constructor
    }

    public static ViewHotels newInstance(String param1, String param2) {
        ViewHotels fragment = new ViewHotels();
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
        View rootView = inflater.inflate(R.layout.fragment_view_hotels, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        loadHotels(recyclerView);
        return rootView;
    }

    public void loadHotels(RecyclerView recyclerView) {
        ArrayList<String> hotelNames = new ArrayList<>(Arrays.asList("Hotel Transelvannia", "Hotel Trivago", "Hotel Vanhorne",
                "Hotel VIP", "Hotel Ai Ai"));
        ArrayList<String> hotelDescs = new ArrayList<>(Arrays.asList("Hotel Transelvannia for all the freaks and monsters", "Trivago the only option", "Vanhorne nothing to tell",
                "Only for VIP", "Hotel where Ai Ai happens"));
        //give arrayList from here or firebase
        imageUrls = new int[]{R.drawable.trans, R.drawable.trivago, R.drawable.ew, R.drawable.vip, R.drawable.aiai};
        ViewHotelsAdapter adapter = new ViewHotelsAdapter(hotelNames, hotelDescs, imageUrls, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }
}