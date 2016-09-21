package com.example.chy.challenge;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class Srearch extends Activity implements View.OnClickListener{
    private EditText searchInput;
    private LinearLayout searchHint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        initview();
    }

    private void initview() {
        searchInput = (EditText) findViewById(R.id.search_input);
        searchHint = (LinearLayout) findViewById(R.id.search_hint);
        searchHint.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_hint:
                searchInput.requestFocus();
                searchHint.setVisibility(View.INVISIBLE);
                break;
            case R.id.search_input:
                searchHint.setVisibility(View.INVISIBLE);
                break;
            default:
                searchHint.setVisibility(View.VISIBLE);
                break;
        }
    }
}
