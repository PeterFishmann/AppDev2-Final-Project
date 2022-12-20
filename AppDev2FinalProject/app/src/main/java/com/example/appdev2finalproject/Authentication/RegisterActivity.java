package com.example.appdev2finalproject.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdev2finalproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    TextView alreadyHaveAccount;
    EditText etEmailSU, etPasswordSU, etPasswordConfirmSU;
    Button btnSignup;
    Spinner spinnerAcccountSpinner;
    String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //INITIALIZING ALL
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        etEmailSU = findViewById(R.id.etEmailSU);
        etPasswordSU = findViewById(R.id.etPasswordSU);
        etPasswordConfirmSU = findViewById(R.id.etPasswordConfirmSU);
        btnSignup = findViewById(R.id.btnSignup);
        spinnerAcccountSpinner = findViewById(R.id.accountSpinner);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        //RETURN TO LOGIN IF ACCOUNT IS ALREADY MADE
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        //SIGNUP METHOD WHEN BUTTON CLICKED
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });

    }

    //AUTHENTICATE INFORMATION
    private void PerformAuth() {
        String email=etEmailSU.getText().toString();
        String password=etPasswordSU.getText().toString();
        String confirmpassword=etPasswordConfirmSU.getText().toString();

        if(!email.matches(emailPattern)){
            etEmailSU.setError("Enter valid email!"); //VALIDATING EMAIL USING REGEX STRING
        } else if(password.isEmpty() || password.length()<8 ){
            etPasswordSU.setError("Enter valid password! Must be over 8 characters!"); //VALIDATING PASSWORD OVER 8 CHARACTERS
        } else if(!password.equals(confirmpassword)){
            etPasswordConfirmSU.setError("Passwords do not match!"); //VALIDATING IF PASSWORDS MATCH
        } else {
            progressDialog.setMessage("Registration in progress!"); //LIVE UPDATE WHILE PUSHING TO DATABASE
            progressDialog.setTitle("Registering");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        nextActivity();
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    //RETURN TO LOGIN IF SIGNUP SUCCESSFUL
    private void nextActivity() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}