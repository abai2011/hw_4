package com.example.hw_4;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinetnHolder> {

    private ArrayList<Continent> continentArrayList;
    private OnItemClick onItemClick;

    public ContinentAdapter(ArrayList<Continent> continentArrayList, OnItemClick onItemClick) {
        this.continentArrayList = continentArrayList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ContinetnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinetnHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continent,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinetnHolder holder, @SuppressLint("RecyclerView") int position) {
 holder.Bind(continentArrayList.get(position));

 holder.itemView.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         onItemClick.onClick(position);
     }
 });
    }

    @Override
    public int getItemCount() {
        return continentArrayList.size();
    }

    public class ContinetnHolder  extends RecyclerView.ViewHolder {
        private ImageView ivContinent;
        private TextView tvContinent;

        public ContinetnHolder(@NonNull View itemView) {
            super(itemView);
            ivContinent = itemView.findViewById(R.id.iv_continet);
            tvContinent = itemView.findViewById(R.id.tv_continet);
        }
        private void Bind(Continent continent){
            tvContinent.setText(continent.getName());
            Glide.with(ivContinent).load(continent.getImage()).into(ivContinent);
        }
    }
}
