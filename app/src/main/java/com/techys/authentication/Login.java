package com.techys.authentication;


<<<<<<< HEAD
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
=======
import android.content.Intent;
import android.os.Bundle;
>>>>>>> main
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
=======

import androidx.appcompat.app.AppCompatActivity;

>>>>>>> main
import com.google.firebase.auth.FirebaseAuth;
import com.techys.R;
import com.techys.mainmenu.Homepage;

public class Login extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

<<<<<<< HEAD
        mEmail= findViewById(R.id.EmailAdress);
=======
        mEmail = findViewById(R.id.EmailAdress);
>>>>>>> main
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginButton);
        mCreateBtn = findViewById(R.id.registerLogin);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
<<<<<<< HEAD
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required.");
                    return;
                }
                if (password.length() < 6) {
                    mPassword.setError("Password must have more than 5 characters.");
                    return;
                }
=======
//                if (TextUtils.isEmpty(email)) {
//                    mEmail.setError("Email is required.");
//                    return;
//                }
//                if (TextUtils.isEmpty(password)) {
//                    mPassword.setError("Password is required.");
//                    return;
//                }
//                if (password.length() < 6) {
//                    mPassword.setError("Password must have more than 5 characters.");
//                    return;
//                }
>>>>>>> main
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(getApplicationContext(), Homepage.class));
                ///authenticate the user

<<<<<<< HEAD
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Homepage.class));
                        } else {
                            Toast.makeText(Login.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                  }
               });
=======
//                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(Login.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        } else {
//                            Toast.makeText(Login.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                });
>>>>>>> main
            }
        });
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                startActivity(new Intent(getApplicationContext(),Register.class));
=======
                startActivity(new Intent(getApplicationContext(), Register.class));
>>>>>>> main

            }
        });
    }
}