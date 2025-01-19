package com.example.nivii;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText etLoginUsername, etLoginPassword;
    CheckBox cbLoginShowHidePassword;
    Button btnLogin;
    TextView tvSingUp;

    SharedPreferences perferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Doremon...");

        perferences = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        editor = perferences.edit();

        if(perferences.getBoolean("isLogin",false))
        {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        etLoginUsername = findViewById(R.id.etLoginUsername);
        etLoginPassword = findViewById(R.id.etLoginPassword);
        cbLoginShowHidePassword = findViewById(R.id.cbLoginShowHidePassword);
        btnLogin = findViewById(R.id.btnLoginLogin);
        tvSingUp = findViewById(R.id.tvSingUP);

        cbLoginShowHidePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked)
                {
                    etLoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    etLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etLoginUsername.getText().toString().isEmpty() )
                {
                    etLoginUsername.setError("Please Enter Your Username And Password");
                }
                else if(etLoginUsername.getText().toString().length() < 8)
                {
                    etLoginUsername.setError("Please Enter Atleast 8 characters");
                }

                else if( etLoginPassword.getText().toString().isEmpty())
                {
                    etLoginPassword.setError("Please Enter Your  Password");
                }
                else if (etLoginPassword.getText().toString().length() <8)
                {
                    etLoginPassword.setError("Please Enter Atleast 8 characters");
                }
                else if (!etLoginUsername.getText().toString().matches(".*[A-Z].*") )
                {
                    etLoginUsername.setError("Please Enter Atleast 1 UperCase Letter");
                }
                else if (!etLoginUsername.getText().toString().matches(".*[a-z].*"))
                {
                    etLoginUsername.setError("Please Enter Atleast 1 LowerCase");
                }
                else if(!etLoginUsername.getText().toString().matches(".*[0-9].*"))
                {
                    etLoginUsername.setError("Please Enter Atleast 1 Digit ");
                }
                else if ( !etLoginUsername.getText().toString().matches(".*[@,#,$,%,^,&,*,!].*"))
                {
                    etLoginUsername.setError("Please Enter Atleast  1 Special Symbol");
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Sucessfully Done", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
                    editor.putBoolean("isLogin",true).commit();
                    startActivity(intent);

                }
            }
        });

        tvSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
    }
}
