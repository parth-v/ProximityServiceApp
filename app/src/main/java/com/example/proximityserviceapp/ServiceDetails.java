package com.example.proximityserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);

    }
    public void openBookSuccessActivity (View view) {
        Intent intent = new Intent(this, BookSuccessActivity.class);
        startActivity(intent);
    }

}