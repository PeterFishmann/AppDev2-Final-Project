package com.example.appdev2finalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdev2finalproject.R;

import java.util.ArrayList;
import java.util.List;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hoteltab, parent, false);
        return new ViewHotelsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHotelsHolder holder, int position) {
        holder.hotelName.setText(hotelNames.get(position));
        holder.hotelDesc.setText(hotelDescs.get(position));
        holder.hotelImg.setImageResource(mImageUrls[position]);
//        String imageUrl = mImageUrls.get(position);
//        Glide.with(myContext)
//                .load(imageUrl)
//                .into(holder.hotelImg);
    }

    @Override
    public int getItemCount() {
        return hotelNames.size();
    }
}
