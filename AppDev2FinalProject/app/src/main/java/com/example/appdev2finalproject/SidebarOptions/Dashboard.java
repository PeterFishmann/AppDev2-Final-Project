package com.example.appdev2finalproject.SidebarOptions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.appdev2finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Dashboard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dashboard extends Fragment {


    View rootview;
    public Dashboard() {
        // Required empty public constructor
    }

    public static Dashboard newInstance() {
        Dashboard fragment = new Dashboard();
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        rootview = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        LinearLayout layout = (LinearLayout) rootview.findViewById(R.id.dashboardLayout);
//        layout.setBackgroundResource(R.drawable.dashboardimg);
    return rootview;
    }
}