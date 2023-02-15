package com.example.midtermpractice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.HashMap;

public class CarRentalAdapter extends RecyclerView.Adapter {

    LayoutInflater layoutInflater;
    HashMap<String, String>[] companies;
    Context context;

    public CarRentalAdapter(@NonNull Context context, HashMap<String,String>[] companies ) {
//        super(context);
        this.companies = companies;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    // START BY CREATING A VIEWHOLDER CLASS WHICH U WILL USE LATER FOR RecyclerView.ViewHolder onCreateViewHolder()
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgCompanyLogo;
        TextView txtCompanyName;

        // THIS MAPS ATTRIBUTES PER ITEM
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCompanyLogo = itemView.findViewById(R.id.imgCompanyLogo);
            txtCompanyName = itemView.findViewById(R.id.txtCompanyName);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            //
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  layoutInflater.inflate(R.layout.recyclerview_car_company, parent, false);
        ViewHolder viewHolder = new ViewHolder(view); // viewHolder holds the layoutInflater
        return viewHolder;
    }

    // THIS IS WHERE YOU APPLY THE IMAGES
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HashMap<String, String> company = companies[position];
        String name = company.get("name");
        int logoId = Integer.parseInt(company.get("logoId"));
        ((ViewHolder)holder).txtCompanyName.setText(name);
        ((ViewHolder)holder).imgCompanyLogo.setImageResource(logoId);
        ((ViewHolder)holder).imgCompanyLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(company.get("url")); // missing 'http://' will cause crashed
                Intent intentUrl = new Intent(Intent.ACTION_VIEW);
                intentUrl.setData(uri);
                context.startActivity(intentUrl);
                Intent intentRent = new Intent(context, RentActivity.class);
                intentRent.putExtra("companyName", name);
                context.startActivity(intentRent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return companies.length ;
    }
}
