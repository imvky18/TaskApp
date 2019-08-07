package com.vsixty.taskapp.Activity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vsixty.taskapp.Fragment.HomeFragment;
import com.vsixty.taskapp.Fragment.NewsEventsFragment;
import com.vsixty.taskapp.Fragment.TaskFragment;
import com.vsixty.taskapp.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView navView;
    Animation animation;
    RelativeLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        navView = findViewById(R.id.nav_view);
        container = findViewById(R.id.container);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        container.startAnimation(animation);
        openFragment(new TaskFragment());

        try {


            if (getIntent().hasExtra("TITLE"))
            {
                TaskFragment fragment = new TaskFragment();
                Bundle bundle = new Bundle();
                bundle.putString("TITLE","TITLE");
                fragment.setArguments(bundle);
                final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameContainer, fragment );
                ft.commit();

                openFragment(new TaskFragment());
            }
        }
        catch (Exception e)
        {

        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openFragment(new HomeFragment());
                    return true;
                case R.id.navigation_newsevents:
                    openFragment(new NewsEventsFragment());
                    return true;
                case R.id.navigation_task:
                    openFragment(new TaskFragment());
                    return true;
            }
            return false;
        }
    };

    public void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameContainer, fragment).commit();
    }

}
