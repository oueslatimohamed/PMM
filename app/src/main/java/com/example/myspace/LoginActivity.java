package com.example.myspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText mLogin;
    EditText mPassword;
    Button mLogin_btn;
    TextView mRegister;
    TextView mHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = (EditText) findViewById(R.id.login_et_login);
        mPassword = (EditText) findViewById(R.id.login_et_password);
        mLogin_btn = (Button) findViewById(R.id.login_et_btn);
        mRegister = (TextView) findViewById(R.id.login_tv_register);
        mHelp = (TextView) findViewById(R.id.login_tv_help);

        mLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });

        mHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , HelpActivity.class);
                startActivity(intent);
            }
        });
    }
}