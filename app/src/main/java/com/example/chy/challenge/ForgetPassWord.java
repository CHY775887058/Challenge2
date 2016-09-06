package com.example.chy.challenge;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by 77588 on 2016/9/1.
 */
public class ForgetPassWord extends Activity implements View.OnClickListener{
    private EditText phone;
    private EditText code;
    private EditText newPassword;
    private EditText newPassword2;
    private Button getCode;
    private RelativeLayout visiblep1,visiblep2,back;
    private Button complete;

    private boolean visibleFlagP1 = true;
    private boolean visibleFlagP2 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repwd);
        initview();
    }

    private void initview() {
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);
        phone = (EditText) findViewById(R.id.phone_repwd);
        code = (EditText) findViewById(R.id.code);
        newPassword = (EditText) findViewById(R.id.newpwd);
        newPassword2 = (EditText) findViewById(R.id.newpwd2);
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
                break;
            case R.id.visiblep1:
                if (visibleFlagP1) {
                    newPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    visibleFlagP1 = false;
                }else {
                    newPassword.setInputType(0x81);
                    visibleFlagP1 = true;
                }
                break;
            case R.id.visiblep2:
                if (visibleFlagP2) {
                    newPassword2.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    visibleFlagP2 = false;
                }else {
                    newPassword2.setInputType(0x81);
                    visibleFlagP2 = true;
                }
                break;
            case R.id.complete:
                break;
            default:
                break;
        }
    }
}
