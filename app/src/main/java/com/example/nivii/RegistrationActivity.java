package com.example.nivii;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    EditText etName,etMobileNo,etEmail,etUsername,etPassword;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        setTitle("Registration");

        etName = findViewById(R.id.etName);
        etMobileNo = findViewById(R.id.etMobileNo);
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty())
                {
                   etName.setError("Please Enter Your Name");
                }
                else if (etEmail.getText().toString().isEmpty())
                {
                    etEmail.setError("Please Enter Your Email");
                }
                else if (etMobileNo.getText().toString().isEmpty())
                {
                    etMobileNo.setError("Please Enter Your Mobile No");
                }
                else if (etUsername.getText().toString().isEmpty())
                {
                    etUsername.setError("Please Enter Your Username");
                }
                else if (etPassword.getText().toString().isEmpty())
                {
                    etPassword.setError("Please Enter Your Password");
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this, "Registration Sucessfully Done", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}