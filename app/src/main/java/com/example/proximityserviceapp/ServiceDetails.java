package com.example.proximityserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import androidx.appcompat.app.AppCompatActivity;

public class ServiceDetails extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    TextView textView;
    Button button;
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnPick);
        button.setOnClickListener(v -> {

            //Make calendar dialog picker for booking service
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(ServiceDetails.this, ServiceDetails.this,year, month,day);
            datePickerDialog.show();
        });
    }

    public void openBookSuccessActivity (View view) {

        //Open book success activity once user is done with data entry passing the service time selected
        Intent intent = new Intent(this, BookSuccessActivity.class);
        TextView text = (TextView) findViewById(R.id.textView);
        String time = String.valueOf(text.getText());
        intent.putExtra("Time", time);
        startActivity(intent);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        //Setting the time picker dialog
        myYear = year;
        myday = day;
        myMonth = month;
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(ServiceDetails.this, ServiceDetails.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        //Setting and displaying date and time to the user along with other service form inputs
        myHour = hourOfDay;
        myMinute = minute;
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.groupradio);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        textView.setText("\n\nSelected Technician: "+ radioButton.getText() +
                "\nScheduled Time:\nDate- " + myday + "/" + myMonth + "/" + myYear +
                "\nTime- " + myHour + ":" + myMinute);
    }
}