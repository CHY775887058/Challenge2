package com.example.chy.challenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by 77588 on 2016/9/6.
 */
public class Setting extends Activity implements View.OnClickListener{
    private RelativeLayout back;
    private LinearLayout phone_binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        initview();
    }
    private void initview() {
        back = (RelativeLayout) findViewById(R.id.back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.phoneBinding:
                startActivity(new Intent(this,PhoneBinding.class));
            default:
                break;
        }
    }
}
