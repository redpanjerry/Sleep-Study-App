package com.example.hwsw_lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.hwsw_lab2.fragment.HomepageFragment;
import com.example.hwsw_lab2.fragment.ProfileFragment;
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

                case R.id.ic_survey:
                    selectedFragment = new SurveyFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();
            return true;
        }
    };
}