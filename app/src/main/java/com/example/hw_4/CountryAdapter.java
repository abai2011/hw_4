package com.example.hw_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryHolder>  {

        public CountryAdapter(ArrayList<Country> countryArrayList) {
            this.countryArrayList = countryArrayList;
        }
        ArrayList<Country> countryArrayList;

    @NonNull
    @Override
    public CountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new  CountryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryHolder holder, int position) {
            holder.Bind(countryArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return countryArrayList.size();
    }

    public class CountryHolder  extends RecyclerView.ViewHolder {
            private ImageView ivCountry;
            private TextView tvCountry;


            public CountryHolder(@NonNull View itemView) {
                super(itemView);
                ivCountry = itemView.findViewById(R.id.iv_country);
                tvCountry = itemView.findViewById(R.id.tv_country);
            }
            private void Bind(Country country){
                tvCountry.setText(country.getName());
                Glide.with(ivCountry).load(country.getImage()).into(ivCountry);
            }
        }
    }




