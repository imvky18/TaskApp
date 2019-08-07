package com.vsixty.taskapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

import com.vsixty.taskapp.R;

public class AddTaskTitleActivity extends AppCompatActivity {
    Animation animation;
    RelativeLayout rlLayout;
    ImageView ivTaskTitleSave;
    EditText etTaskTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_title);
        initUI();

    }

    private void initUI() {
        etTaskTitle = findViewById(R.id.etTaskTitle);
        rlLayout = findViewById(R.id.rlLayout);
        ivTaskTitleSave = findViewById(R.id.ivTaskTitleSave);
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        rlLayout.startAnimation(animation);


        etTaskTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

              ivTaskTitleSave.setVisibility(View.VISIBLE);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                ivTaskTitleSave.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

                ivTaskTitleSave.setVisibility(View.VISIBLE);

            }
        });




        ivTaskTitleSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddTaskTitleActivity.this, BottomNavigationActivity.class);
                intent.putExtra("TITLE",etTaskTitle.getText().toString());
                startActivity(intent);
            }
        });
    }


}
