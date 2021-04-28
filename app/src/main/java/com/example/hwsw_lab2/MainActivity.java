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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView sSignUpBtn;
    private Button sLoginBtn;
    private EditText sEmailField, sPasswordField;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sSignUpBtn = (TextView) findViewById(R.id.sSignupBtn);
        sLoginBtn = (Button) findViewById(R.id.sLoginBtn);

        sEmailField = (EditText) findViewById(R.id.emailField);
        sPasswordField = (EditText) findViewById(R.id.passwordField);

        mAuth = FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.loginProgress);

        sLoginBtn.setOnClickListener(this);
        sSignUpBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sSignupBtn:
                startActivity(new Intent(this, registerUser.class));
                break;

            case R.id.sLoginBtn:
                userLogin();
                break;
        }

    }

    private void userLogin(){
        String email = sEmailField.getText().toString().trim();
        String password = sPasswordField.getText().toString().trim();

        if (email.isEmpty()){
            sEmailField.setError("Email is required!");
            sEmailField.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            sEmailField.setError("Please enter a valid email!");
            sEmailField.requestFocus();
            return;
        }

        if(password.isEmpty()){
            sPasswordField.setError("Password is required!");
            sPasswordField.requestFocus();
            return;
        }

        if(password.length() < 6){
            sPasswordField.setError("Min password length is 6 characters!");
            sPasswordField.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    // redirect to user profile page
                    if (user.isEmailVerified()) {
                        startActivity(new Intent(MainActivity.this, UserHomepage.class));
                    }
                    else{
                        user.sendEmailVerification();
                        Toast.makeText(MainActivity.this, "Check your email to verify your account", Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(MainActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}