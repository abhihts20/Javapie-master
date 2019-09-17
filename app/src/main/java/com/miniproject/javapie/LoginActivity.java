package com.miniproject.javapie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView forgetText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = findViewById(R.id.log_button);
        final EditText editEmail = findViewById(R.id.edt_email);
        final EditText editPass = findViewById(R.id.edt_pass);
        final TextView edtsignup=findViewById(R.id.regis_txt);
        forgetText=findViewById(R.id.forg_txt);
        final Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation(editEmail.getText().toString(), editPass.getText().toString());
                startActivity(intent);
            }
        });
        forgetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(LoginActivity.this,ForgotpassActivity.class);
                startActivity(intent2);
            }
        });
        edtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
    }
    private void validation(String id, String pass) {
        if (id.length() < 4) {
            Toast.makeText(LoginActivity.this, "Id cannot be less than 4", Toast.LENGTH_SHORT).show();
        } else if (pass.length() < 4) {
            Toast.makeText(LoginActivity.this, "Password cannot be less than 4", Toast.LENGTH_LONG).show();
        } else if (id.equals("admin") && pass.equals("admin")) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Invalid Username/Id", Toast.LENGTH_LONG).show();
        }
    }
}
