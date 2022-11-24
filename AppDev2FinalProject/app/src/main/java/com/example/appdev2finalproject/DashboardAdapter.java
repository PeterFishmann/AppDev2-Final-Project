package com.example.appdev2finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<String> menuOptions = new ArrayList<>();
    private Context myContext;

    public DashboardAdapter(ArrayList<String> menuOptions, Context myContext) {
        this.menuOptions = menuOptions;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menutab, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.btn.setText(menuOptions.get(position));
    }

    @Override
    public int getItemCount() {
        return menuOptions.size();
    }
}
