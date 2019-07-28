package com.example.yingying.login;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    SharedPreferences sp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        bt_login = findViewById(R.id.login);
        bt_register = findViewById(R.id.register);

        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        if(!(sp.getString("username", null).equals("") && sp.getString("password", null).equals(""))) {
            et_username.setText(sp.getString("username", null));
            et_password.setText(sp.getString("password", null));
            if( et_username.getText().toString().equals("admin" )&& et_password.getText().toString().equals("123456")){
                Toast.makeText(this, "上次记录账号自动登录成功！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(login.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( et_username.getText().toString().equals("admin" )&& et_password.getText().toString().equals("123456")){

                    sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                    sp.edit().putString("username", et_username.getText().toString()).putString("password",
                            et_password.getText().toString()).apply();

                    Intent intent = new Intent();
                    intent.setClass(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(login.this, "账号或者密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
