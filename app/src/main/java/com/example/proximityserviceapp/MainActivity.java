package com.example.proximityserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openServiceListActivity(View view){
        Intent intentGetStarted = new Intent(MainActivity.this, ServiceList.class);
        startActivity(intentGetStarted);
    }

    public void openServiceDetailsActivity(View view){
        Intent intent = new Intent(this, ServiceDetails.class);
        startActivity(intent);
    }
}