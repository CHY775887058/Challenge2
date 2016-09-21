package com.example.chy.challenge;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.chy.challenge.NetInfo.GetCode;

/**
 * Created by 77588 on 2016/9/1.
 */
public class ForgetPassWord extends Activity implements View.OnClickListener{
    private EditText inputPhone,inputCode,inputNewPassword,inputNewPassword2;
    private Button getCode;
    private RelativeLayout visiblep1,visiblep2,back;
    private Button complete;
    private Context mContext;
    private String phone,code,newPassWord;

    private boolean visibleFlagP1 = true;
    private boolean visibleFlagP2 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repwd);
        mContext = this;
        initview();
    }

    private void initview() {
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);
        inputPhone = (EditText) findViewById(R.id.phone_repwd);
        inputCode = (EditText) findViewById(R.id.code);
        inputNewPassword = (EditText) findViewById(R.id.newpwd);
        inputNewPassword2 = (EditText) findViewById(R.id.newpwd2);
        getCode = (Button) findViewById(R.id.getcode);
        getCode.setOnClickListener(this);
        visiblep1 = (RelativeLayout) findViewById(R.id.visiblep1);
        visiblep1.setOnClickListener(this);
        visiblep2 = (RelativeLayout) findViewById(R.id.visiblep2);
        visiblep2.setOnClickListener(this);
        complete = (Button) findViewById(R.id.complete);
        complete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.getcode:
                phone = inputPhone.getText().toString();
                if (phone == null||"".equals(phone)){
                    Toast.makeText(mContext,"请先输入手机号！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phone.length()!=11){
                    Toast.makeText(mContext,"手机号格式错误，请重新输入！",Toast.LENGTH_SHORT).show();
                    return;
                }
                GetCode gc = new GetCode();
                code = gc.GetCode(inputPhone.getText().toString(),mContext);
                getCode.setEnabled(false);
                new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getCode.setEnabled(true);
                }
            }.start();
                break;
            case R.id.visiblep1:
                if (visibleFlagP1) {
                    inputNewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    visibleFlagP1 = false;
                }else {
                    inputNewPassword.setInputType(0x81);
                    visibleFlagP1 = true;
                }
                break;
            case R.id.visiblep2:
                if (visibleFlagP2) {
                    inputNewPassword2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    visibleFlagP2 = false;
                }else {
                    inputNewPassword2.setInputType(0x81);
                    visibleFlagP2 = true;
                }
                break;
            case R.id.complete:
                if (inputPhone==null||"".equals(inputPhone)){
                    Toast.makeText(mContext,"手机号不能为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("false".equals(code)){
                    Toast.makeText(mContext,"请先获取验证码！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (inputNewPassword==null||"".equals(inputNewPassword)||inputNewPassword2==null||"".equals(inputNewPassword2)){
                    Toast.makeText(mContext,"密码不能为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!inputNewPassword.equals(inputNewPassword2)){
                    Toast.makeText(mContext,"两次密码不一致！",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!code.equals(inputCode)){
                    Toast.makeText(mContext,"验证码错误！",Toast.LENGTH_SHORT).show();
                    code = null;
                    return;
                }
                newPassWord = inputNewPassword.getText().toString();
                break;
            default:
                break;
        }
    }
}
