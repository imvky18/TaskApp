package com.vsixty.taskapp.Splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.vsixty.taskapp.Activity.BottomNavigationActivity;
import com.vsixty.taskapp.MainActivity;
import com.vsixty.taskapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this, BottomNavigationActivity.class);
                startActivity(intent);
            }
        }, 3000);
    }
}
