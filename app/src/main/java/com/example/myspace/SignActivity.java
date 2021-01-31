package com.example.myspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import model.User;
import services.DatabasHelper;

public class SignActivity extends AppCompatActivity {
    EditText mName;
    EditText mLastname;
    EditText mAge;
    EditText mUsername;
    EditText mPassword;
    Button mSign;
    TextView mLogin;

    DatabasHelper databasHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        mName = (EditText) findViewById(R.id.sign_et_name);
        mLastname = (EditText) findViewById(R.id.sign_et_lastname);
        mAge = (EditText) findViewById(R.id.sign_et_age);
        mUsername = (EditText) findViewById(R.id.sign_et_username);
        mPassword = (EditText) findViewById(R.id.sign_et_password);
        mSign = (Button) findViewById(R.id.sing_et_btn);
        mLogin = (TextView) findViewById(R.id.sign_tv_login);
        databasHelper  = new DatabasHelper(this);

        String name = mName.getText().toString();
        String lastname = mLastname.getText().toString();
        String age = mAge.getText().toString();
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        mSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* if(TextUtils.isEmpty(name) || TextUtils.isEmpty(lastname) || TextUtils.isEmpty(age) || TextUtils.isEmpty(username)
                        || TextUtils.isEmpty(password)) {
                    Toast.makeText(SignActivity.this , "Veuillez remplir tous les champs",Toast.LENGTH_LONG).show();
                } else {*/
                    createAccount(name,lastname,age,username,password);
                    Intent intent = new Intent(SignActivity.this , LoginActivity.class);
                    startActivity(intent);
                //}

            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createAccount(String name , String lastname , String age , String username , String password){
        User user = new User(1,name,lastname,age,username,password);
            databasHelper.addUser(user);
            databasHelper.close();
    }

}