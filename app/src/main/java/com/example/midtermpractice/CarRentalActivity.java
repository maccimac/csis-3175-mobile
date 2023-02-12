package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class CarRentalActivity extends AppCompatActivity {

    HashMap<String, String>[] companies;
    String[] companiesStringArr = {"hertz", "enterprise"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rental);


        RecyclerView recyclerCompanies = findViewById(R.id.recyclerCompanies);
        int columnCount = 1;
        recyclerCompanies.setLayoutManager(new GridLayoutManager(this, columnCount));
        companies = prepareCompanies(companiesStringArr);
        CarRentalAdapter adapter = new CarRentalAdapter(this, companies );
        recyclerCompanies.setAdapter(adapter);

    }

    public HashMap<String , String>[] prepareCompanies (String[] companiesArr){
        HashMap<String, String>[] companiesHash = new HashMap[companiesArr.length];

        Resources r = getResources();


        for (int i = 0; i < companiesArr.length; i++) {
            String comp = companiesArr[i];
            HashMap<String, String> singleHash = new HashMap<>();

            String drawableName = "logo_" + comp;
            int drawableId = r.getIdentifier(drawableName, "drawable", "com.example.midtermpractice");
            System.out.println(drawableName + ": " + drawableId);

            Drawable compLogo = r.getDrawable(drawableId);
            singleHash.put("name", comp);
            singleHash.put("logoId",  Integer.toString(drawableId));
            singleHash.put("url",  "http://google.com");
            companiesHash[i] = singleHash;

        }

        System.out.println(Arrays.asList(companiesHash));
        return companiesHash;

    }
}