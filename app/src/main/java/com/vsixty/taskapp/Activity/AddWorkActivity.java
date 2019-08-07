package com.vsixty.taskapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.vsixty.taskapp.Connect.Utilies;
import com.vsixty.taskapp.R;

import java.util.Calendar;

public class AddWorkActivity extends AppCompatActivity {

TextView tvTime;
    EditText edWork;
    ImageView ivAddWorkSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work);
        initUI();
    }

    private void initUI() {

        ivAddWorkSave = findViewById(R.id.ivAddWorkSave);
        tvTime = findViewById(R.id.tvTime);
        edWork = findViewById(R.id.edWork);
        tvTime.setText(Utilies.getCurrentTime());

        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);

// Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddWorkActivity.this, R.style.CalendarDatePickerDialog,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {


                                tvTime.setText(hourOfDay + ":" + minute);


                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        if (edWork.getText().length()>0)
        {
            ivAddWorkSave.setVisibility(View.VISIBLE);
        }
        else
        {
            ivAddWorkSave.setVisibility(View.GONE);
        }
        edWork.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (edWork.getText().length()>0)
                {
                    ivAddWorkSave.setVisibility(View.VISIBLE);
                }
                else
                {
                    ivAddWorkSave.setVisibility(View.GONE);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (edWork.getText().length()>0)
                {
                    ivAddWorkSave.setVisibility(View.VISIBLE);
                }
                else
                {
                    ivAddWorkSave.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edWork.getText().length()>0)
                {
                    ivAddWorkSave.setVisibility(View.VISIBLE);
                }
                else
                {
                    ivAddWorkSave.setVisibility(View.GONE);
                }

            }
        });

        ivAddWorkSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddWorkActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
