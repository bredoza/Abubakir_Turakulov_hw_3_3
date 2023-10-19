package com.example.abubakir_turakulov_hw_3_3;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import java.text.DecimalFormat;
import java.util.Random;

public class ObjectAdapter extends RecyclerView.Adapter<ObjectViewHolder> {

    private ArrayList<String> friendNames;
    private ArrayList<String> friendTexts;
    private ArrayList<Integer> avatarResource;

    public ObjectAdapter(ArrayList<String> friendNames, ArrayList<String> friendTexts, ArrayList<Integer> avatarResourceIds) {
        this.friendNames = friendNames;
        this.friendTexts = friendTexts;
        this.avatarResource = avatarResourceIds;
    }

    @NonNull
    @Override
    public ObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ObjectViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_object, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectViewHolder holder, int position) {
        String friendName = friendNames.get(position);
        String friendText = friendTexts.get(position);
        int avatarResourceId = avatarResource.get(position);

        Random random = new Random();
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);

        DecimalFormat decimalFormat = new DecimalFormat("00");
        String time = decimalFormat.format(hours) + ":" + decimalFormat.format(minutes);

        holder.onBind(friendName, friendText, avatarResourceId, time);
    }

    @Override
    public int getItemCount() {
        return friendNames.size();
    }
}
