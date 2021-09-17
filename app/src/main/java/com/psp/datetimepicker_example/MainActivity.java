package com.psp.datetimepicker_example;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDateTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDateTimePicker = findViewById(R.id.btnDateTimePicker);


        btnDateTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog();
            }
        });
    }

    private void timePickerDialog() {
        final Calendar myCalender = Calendar.getInstance();
        int hour = myCalender.get(Calendar.HOUR_OF_DAY);
        int minute = myCalender.get(Calendar.MINUTE);


        TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                if (view.isShown()) {

                    myCalender.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    myCalender.set(Calendar.MINUTE, minute);

                    String min = Integer.toString(minute);
                    String hour = Integer.toString(hourOfDay);

                    if(hour.length()==1) {
                        hour = "0"+hour;
                    }
                    if(min.length()==1) {
                        min = "0"+min;
                    }
                    
                    Toast.makeText(MainActivity.this, "Time is "+hour+" : "+min, Toast.LENGTH_SHORT).show();
                }
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this
                , android.R.style.Theme_Holo_Light_Dialog_NoActionBar, myTimeListener, hour, minute, true);
        timePickerDialog.setTitle("Time Picker");
        timePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        timePickerDialog.show();
    }
}