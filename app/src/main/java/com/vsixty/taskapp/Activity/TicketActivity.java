package com.vsixty.taskapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vsixty.taskapp.Connect.Utilies;
import com.vsixty.taskapp.R;

public class TicketActivity extends AppCompatActivity {
    EditText edQuery;
    ImageView ivTicketSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        initUI();
    }

    private void initUI() {


        ivTicketSave = findViewById(R.id.ivTicketSave);

        edQuery = findViewById(R.id.edQuery);

        if (edQuery.getText().length() > 0) {
            ivTicketSave.setVisibility(View.VISIBLE);
        } else {
            ivTicketSave.setVisibility(View.GONE);
        }
        edQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (edQuery.getText().length() > 0) {
                    ivTicketSave.setVisibility(View.VISIBLE);
                } else {
                    ivTicketSave.setVisibility(View.GONE);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                if (edQuery.getText().length() > 0) {
                    ivTicketSave.setVisibility(View.VISIBLE);
                } else {
                    ivTicketSave.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edQuery.getText().length() > 0) {
                    ivTicketSave.setVisibility(View.VISIBLE);
                } else {
                    ivTicketSave.setVisibility(View.GONE);
                }

            }
        });

        ivTicketSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TicketActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
