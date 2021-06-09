package com.example.hwsw_lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hwsw_lab2.fragment.HomepageFragment;
import com.example.hwsw_lab2.fragment.ProfileFragment;
import com.example.hwsw_lab2.fragment.Sleep_status;
import com.example.hwsw_lab2.fragment.SurveyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserHomepage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_homepage);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomepageFragment()).commit();
        }
//
//        HomepageFragment homepageFragment = new HomepageFragment();
//        FragmentManager fm = getSupportFragmentManager();
//
//        fm.beginTransaction().add(R.id.user_homepage_layout, homepageFragment).commit();


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.ic_home:
                    selectedFragment = new HomepageFragment();
                    break;

                case R.id.ic_profile:
                    selectedFragment = new ProfileFragment();
                    break;

                case R.id.ic_black_panther:
                    selectedFragment = new SurveyFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
}