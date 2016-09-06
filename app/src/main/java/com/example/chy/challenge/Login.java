package com.example.chy.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Login extends Activity implements View.OnClickListener{
    private EditText phone ;
    private EditText passWord;
    private Button login;
    private TextView forgetPwd;
    private TextView regist;
    private ImageButton QQLogin;
    private ImageButton WechatLogin;
    private ImageButton WeiboLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initview();

    }

    private void initview() {
        phone = (EditText) findViewById(R.id.phone);
        passWord = (EditText) findViewById(R.id.passWord);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        forgetPwd = (TextView) findViewById(R.id.forgetPwd);
        forgetPwd.setOnClickListener(this);
        regist = (TextView) findViewById(R.id.regist);
        regist.setOnClickListener(this);
        QQLogin = (ImageButton) findViewById(R.id.QQLogin);
        WechatLogin = (ImageButton) findViewById(R.id.WechatLogin);
        WeiboLogin = (ImageButton) findViewById(R.id.WeboLogin);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                startActivity(new Intent(this,Identity.class));
                break;
            case R.id.forgetPwd:
                startActivity(new Intent(this,ForgetPassWord.class));
                break;
            case R.id.regist:
                startActivity(new Intent(this,Regist.class));
                break;
            default:
                break;
        }

    }
}
