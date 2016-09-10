package com.example.chy.challenge.AboutResume;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.chy.challenge.R;

/**
 * Created by 77588 on 2016/9/10.
 */
public class Objective extends Activity implements View.OnClickListener{
    private RelativeLayout back;
    private ImageView compelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.objective);
        initview();
    }

    private void initview() {
        back = (RelativeLayout) findViewById(R.id.back );
        back.setOnClickListener(this);
        compelete = (ImageView) findViewById(R.id.save);
        compelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.save:
                finish();
                break;
            default:
                break;
        }
    }
}
