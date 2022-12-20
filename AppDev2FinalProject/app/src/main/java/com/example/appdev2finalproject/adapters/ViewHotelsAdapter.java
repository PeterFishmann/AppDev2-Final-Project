package com.example.appdev2finalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdev2finalproject.R;

import java.util.ArrayList;

public class ViewHotelsAdapter extends RecyclerView.Adapter<ViewHotelsHolder> {

    public int[] mImageUrls;
    public ArrayList<String> hotelNames;
    public ArrayList<String> hotelDescs;
    public Context myContext;

    public ViewHotelsAdapter(ArrayList<String> hotelNames, ArrayList<String> hotelDescs, int[] imageUrls, Context myContext) {
        this.hotelNames = hotelNames;
        this.hotelDescs = hotelDescs;
        this.myContext = myContext;
        mImageUrls = imageUrls;
    }

    @NonNull
    @Override
    public ViewHotelsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhotelchild, parent, false);
        return new ViewHotelsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHotelsHolder holder, int position) {
        holder.hotelName.setText(hotelNames.get(position));
        holder.hotelDesc.setText(hotelDescs.get(position));
        holder.hotelImg.setImageResource(mImageUrls[position]);
    }

    @Override
    public int getItemCount() {
        return hotelNames.size();
    }
}
