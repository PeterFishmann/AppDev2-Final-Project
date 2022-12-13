package com.example.appdev2finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnSignup, aliButton;
    EditText etEmail, etPassword;
    String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALIZING ALL
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        btnLogin = findViewById(R.id.btnLogin);

        btnSignup = findViewById(R.id.btnSignup);
        aliButton = findViewById(R.id.button2);

        //ENTER SIGNUP PAGE
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        //LOGIN IF ALL IS SUCCESSFUL
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformLogin();
            }
        });

        aliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Dashboard.class));
            }
        });

    }

    //METHOD TO CREATE LOGIN
    private void PerformLogin() {
        String email=etEmail.getText().toString();
        String password=etPassword.getText().toString();

        //VALIDATING EMAIL
        if(!email.matches(emailPattern)){
            etEmail.setError("Enter correct email!");
        } else if(password.isEmpty() || password.length()<8 ){
            etPassword.setError("Enter correct password!"); //VALIDATING PASSWORD
        } else {
            progressDialog.setMessage("Logging in!"); //PROGRESS DIALOG TO SHOW USER LIVE UPDATE WHILE CHECKING DATABASE
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override // OPENS DASHBOARD OR RELAYS MESSAGE WITH INCORRECT DETAILS
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        nextActivityDashboard();
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    //METHOD TO ENTER DASHBOARD WHEN LOGIN SUCCESSFUL
    private void nextActivityDashboard() {
        Intent intent = new Intent(MainActivity.this, Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}