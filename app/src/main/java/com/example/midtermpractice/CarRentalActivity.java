package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Field;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CarRentalActivity extends AppCompatActivity {

    HashMap<String, String>[] companies;
    ArrayList<HashMap<String, String>> compArrList = new ArrayList<>();
    String[] companiesStringArr = {"hertz", "enterprise"};
    RecyclerView recyclerCompanies;
    ListView listCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_rental);

        recyclerCompanies = findViewById(R.id.recyclerCompanies);
        listCompanies = findViewById(R.id.listviewCompanies);

        int columnCount = 1;
        recyclerCompanies.setLayoutManager(new GridLayoutManager(this, columnCount));
        companies = prepareCompanies(companiesStringArr);

        CarRentalAdapter adapter = new CarRentalAdapter(this, companies );
        recyclerCompanies.setAdapter(adapter);
        setupListView(compArrList);
    }

    public void setupListView(ArrayList<HashMap<String, String>> arrList){
        String[] fromHashKeys = {"name", "logoId"};
        int[] toElements = {R.id.labelCompName, R.id.imgCompanyLogoList};

        SimpleAdapter adapter = new SimpleAdapter(CarRentalActivity.this, arrList, R.layout.listview_car_company, fromHashKeys, toElements );
        listCompanies.setAdapter(adapter);
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

            compArrList.add(singleHash);
        }
        System.out.println(Arrays.asList(companiesHash));
        return companiesHash;
    }
}