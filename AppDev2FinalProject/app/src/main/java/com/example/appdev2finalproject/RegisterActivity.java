package com.example.appdev2finalproject;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class RegisterActivity extends AppCompatActivity {

    TextView alreadyHaveAccount;
    EditText etEmailSU, etPasswordSU, etPasswordConfirmSU, fname, lname;
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
        fname = findViewById(R.id.name);
        lname = findViewById(R.id.lastName);
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
        String firstName = fname.getText().toString();
        String lastName = lname.getText().toString();
        String email=etEmailSU.getText().toString();
        String password=etPasswordSU.getText().toString();
        String confirmpassword=etPasswordConfirmSU.getText().toString();

        if(!email.matches(emailPattern)){
            etEmailSU.setError("Enter valid email!"); //VALIDATING EMAIL USING REGEX STRING
        } else if(password.isEmpty() || password.length()<8 ){
            etPasswordSU.setError("Enter valid password! Must be over 8 characters!"); //VALIDATING PASSWORD OVER 8 CHARACTERS
        } else if(!password.equals(confirmpassword)){
            etPasswordConfirmSU.setError("Passwords do not match!"); //VALIDATING IF PASSWORDS MATCH
        } else if(firstName.isEmpty()){
            fname.setError("Enter your first name!");
        } else if(lastName.isEmpty()){
            lname.setError("Enter your last name!");
        }else {
            progressDialog.setMessage("Registration in progress!"); //LIVE UPDATE WHILE PUSHING TO DATABASE
            progressDialog.setTitle("Registering");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        progressDialog.dismiss();
                        updateUI(user);
//                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        // If sign in fails, display a message to the user
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });

        }
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            // Navigate to a new activity or display the user's information
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            // Display an error message or do nothing
            // If sign in fails, display a message to the user
//            Log.w(TAG, "createUserWithEmail:failure", task.getException());
            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                    Toast.LENGTH_SHORT).show();
            updateUI(null);
        }
    }
}