package com.example.yingying.login;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yingying.MainActivity;
import com.example.yingying.R;

public class login extends AppCompatActivity{

    EditText et_username;
    EditText et_password;
    Button bt_login ;
    Button bt_register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        bt_login = findViewById(R.id.login);
        bt_register = findViewById(R.id.register);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( et_username.getText().toString().equals("admin" )&& et_password.getText().toString().equals("123456")){


                    Intent intent = new Intent();
        intent.setClass(login.this, MainActivity.class);
        startActivity(intent);
                }
                else{
                    Toast.makeText(login.this, "账号或者密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
