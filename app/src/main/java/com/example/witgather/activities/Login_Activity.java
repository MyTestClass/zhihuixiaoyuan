package com.example.witgather.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.witgather.R;

public class Login_Activity extends Activity implements View.OnClickListener{
    private Button mBtnLogin;
    private EditText userId;
    private EditText psw;
    private TextView register;
    private TextView forget;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        mBtnLogin = (Button) findViewById(R.id.main_btn_login);
        userId = (EditText)findViewById(R.id.login_userId);
        psw = (EditText)findViewById(R.id.login_psw);
        mBtnLogin.setOnClickListener(this);
        register = (TextView)findViewById(R.id.login_register);
        register.setOnClickListener(this);
        forget = (TextView)findViewById(R.id.login_forget);
        forget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.main_btn_login){
            userId.getText();
            psw.getText();
            finish();
        }else if(id==R.id.login_forget){

        }else if(id==R.id.login_register){
            Intent intent = new Intent();
            intent.setClass(this,Register_Activity.class);
            startActivity(intent);

        }
    }
}
