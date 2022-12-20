package com.example.appdev2finalproject.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdev2finalproject.R;

public class ViewHotelsHolder extends RecyclerView.ViewHolder {

    public ImageView hotelImg;
    public TextView hotelName, hotelDesc;

    public ViewHotelsHolder(@NonNull View itemView) {
        super(itemView);
        hotelImg = itemView.findViewById(R.id.hotelImg);
        hotelName = itemView.findViewById(R.id.hotelName);
        hotelDesc = itemView.findViewById(R.id.hotelDesc);
    }
}
