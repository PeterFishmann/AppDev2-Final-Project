package com.example.appdev2finalproject;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

        Button btn;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        btn = itemView.findViewById(R.id.button);
    }
}
