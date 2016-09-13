package com.example.chy.challenge;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.chy.challenge.Fragment.Chance;
import com.example.chy.challenge.Fragment.Messages;
import com.example.chy.challenge.Fragment.MineForPerson;
import com.example.chy.challenge.Fragment.Resume;

/**
 * Created by 77588 on 2016/9/1.
 */
public class SalaryMain extends Activity implements View.OnClickListener,MineForPerson.btnSettingListener{
    private RadioButton btnChance,btnResume,btnMessage,btnMine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_salary);
        initview();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Chance chance = new Chance();
        transaction.replace(R.id.salary_layout,chance);
        transaction.commit();
    }

    private void initview() {
        btnChance = (RadioButton) findViewById(R.id.btnChance);
        btnChance.setOnClickListener(this);
        btnResume = (RadioButton) findViewById(R.id.btnResume);
        btnResume.setOnClickListener(this);;
        btnMessage = (RadioButton) findViewById(R.id.btnMessage);
        btnMessage.setOnClickListener(this);
        btnMine = (RadioButton) findViewById(R.id.btnMine);
        btnMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.btnChance:
                Chance chance = new Chance();
                transaction.replace(R.id.salary_layout,chance);
                transaction.commit();
                break;
            case R.id.btnResume:
                Resume resume = new Resume();
                transaction.replace(R.id.salary_layout,resume);
                transaction.commit();
                break;
            case  R.id.btnMessage:
                Messages messages = new Messages();
                transaction.replace(R.id.salary_layout,messages);
                transaction.commit();
                break;
            case R.id.btnMine:
                MineForPerson mineForPerson = new MineForPerson();
                transaction.replace(R.id.salary_layout, mineForPerson);
                transaction.commit();
                break;
            default:
                break;
        }

    }

    @Override
    public void onBtnSettingClick() {
        startActivity(new Intent(this,Settings.class));
    }
}
