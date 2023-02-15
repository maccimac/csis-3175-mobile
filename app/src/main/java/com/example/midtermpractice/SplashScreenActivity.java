package com.example.midtermpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intentMain = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        };
        Timer opening = new Timer();
        opening.schedule(task, 2000);
    }
}