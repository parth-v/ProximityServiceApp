package com.example.proximityserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookSuccessActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_success);
        Intent intent = getIntent();
        String time = intent.getStringExtra("Time");
        TextView textView = (TextView) findViewById(R.id.textSuccessHeader);
        textView.setText(String.format("Booking Successful ! %s", time));
    }
}