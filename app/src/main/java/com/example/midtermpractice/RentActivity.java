package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RentActivity extends AppCompatActivity {
    Button btnCalculate;
    TextView txtFinalCost;
    Spinner spinnerCarType;
    EditText editInputNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        spinnerCarType = findViewById(R.id.spinnerCarTypes);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtFinalCost = findViewById(R.id.txtFinalCost);
        editInputNum = findViewById(R.id.editTxtNumDays);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCost();
            }
        });
    }

    public void calculateCost(){

        String selection = spinnerCarType.getSelectedItem().toString();
        String numDays = String.valueOf(editInputNum.getText());
        System.out.println(numDays);

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
        double finalCost = charge * Integer.parseInt(numDays);
        txtFinalCost.setText("Final cost is " + finalCost);
    }

}