package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtName;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        btnStart = findViewById(R.id.btnStart);

        setupMainView();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent redirectToCarRental = new Intent( MainActivity.this, CarRentalActivity.class );
                startActivity(redirectToCarRental);
            }
        });
    }

    public void setupMainView(){
        String fullName = getString(R.string.firstname) + " " + getString(R.string.lastname);
        txtName.setText(fullName);
    }
}