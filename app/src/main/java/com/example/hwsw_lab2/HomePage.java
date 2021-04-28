package com.example.hwsw_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private Button hLoginBtn;
    private TextView hSignUpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        hLoginBtn = (Button) findViewById(R.id.homepage_loginbtn);
        hSignUpbtn = (TextView) findViewById(R.id.homepage_signupbtn);

        hLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(HomePage.this, MainActivity.class);

                startActivity(intent);
            }
        });

        hSignUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(HomePage.this, registerUser.class);

                startActivity(intent);
            }
        });

    }
}