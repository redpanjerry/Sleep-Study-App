package com.example.hwsw_lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registerUser extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth mAuth;
    private TextView mHomePage, mSigninbtn;
    private EditText mNameField, mEmailField, mPasswordField;
    private Button mRegister;
    private ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        mAuth = FirebaseAuth.getInstance();

        mHomePage = (TextView) findViewById(R.id.homePageBanner);
        mNameField = (EditText) findViewById(R.id.nameField);
        mEmailField = (EditText) findViewById(R.id.rEmailField);
        mPasswordField = (EditText) findViewById(R.id.rPasswordField);
        mRegister = (Button) findViewById(R.id.registerBtn);
        mSigninbtn = (TextView) findViewById(R.id.rSigninBtn);

        mProgressbar = (ProgressBar) findViewById(R.id.registerProgress);

        mHomePage.setOnClickListener(this);
        mRegister.setOnClickListener(this);

        mSigninbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(registerUser.this, MainActivity.class);

                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.homePageBanner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.registerBtn:
                registerNewUser();
                break;
        }

    }

    private void registerNewUser(){

        String email = mEmailField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();
        String name = mNameField.getText().toString().trim();

        if (name.isEmpty()){
            mNameField.setError("Full name is required");
            mNameField.requestFocus();

            return;
        }


        if (email.isEmpty()){
            mEmailField.setError("Email is required");
            mEmailField.requestFocus();

            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmailField.setError("Please enter valid email");
            mEmailField.requestFocus();

            return;
        }

        if (password.isEmpty()){
            mPasswordField.setError("Password is required");
            mPasswordField.requestFocus();

            return;
        }

        if (password.length() < 6){
            mPasswordField.setError("Min password length should be 6 characters");
            mPasswordField.requestFocus();

            return;
        }

        mProgressbar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(name, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(registerUser.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
                                        mProgressbar.setVisibility(View.GONE);
                                    }

                                    else{
                                        Toast.makeText(registerUser.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                        mProgressbar.setVisibility(View.GONE);
                                    }

                                }
                            });
                        }else{
                            Toast.makeText(registerUser.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                            mProgressbar.setVisibility(View.GONE);
                        }
                    }
                });


    }
}