package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RentActivity extends AppCompatActivity {
    Button btnCalculate;
    TextView txtFinalCost;
    Spinner spinnerCarType;
    EditText editInputNum;
    TextView labelRentACar;
    RadioButton radioWithin;
    RadioButton radioBeyond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        spinnerCarType = findViewById(R.id.spinnerCarTypes);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtFinalCost = findViewById(R.id.txtFinalCost);
        editInputNum = findViewById(R.id.editTxtNumDays);
        labelRentACar = findViewById(R.id.labelRentACar);
        radioWithin = findViewById(R.id.radioWithin);
        radioBeyond = findViewById(R.id.radioBeyond);


        Intent companyIntent = getIntent();
        if(companyIntent!=null){
            String newLabel = companyIntent.getStringExtra("companyName");
            labelRentACar.setText(newLabel);
        }

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCost();
            }
        });
    }

    public void calculateCost(){
        String selection = spinnerCarType.getSelectedItem().toString();
        String numDaysString = String.valueOf(editInputNum.getText());
        Integer numDays = Integer.parseInt(numDaysString);

        double charge  = 0;
        switch (selection) {
            case "SUV":
                charge = 55.99;
                break;
            case "Economy":
                charge = 35.99;
                break;
            case "Minivan":
                charge = 30.99;
                break;
            case "Convertible":
                charge = 65.99;
                break;
        }
        double finalCost = charge * numDays;
        boolean hasDiscount = numDays > 6;
        if(hasDiscount){
            finalCost = finalCost * 0.85;
        }
        String finalCostFormatted = String.format("%, .2f", finalCost);
        String finalResult = "Final cost is $" + finalCostFormatted;

        String location = " in Canada";
        if(radioBeyond.isChecked()){
            location = " beyond BC";
        }

        finalResult += location;


        if (hasDiscount) finalResult += " with discount";


        txtFinalCost.setText(finalResult);
    }
}