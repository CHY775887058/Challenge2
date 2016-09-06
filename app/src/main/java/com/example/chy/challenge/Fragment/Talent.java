package com.example.chy.challenge.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.chy.challenge.R;

/**
 * Created by 77588 on 2016/9/2.
 */
public class Talent extends Fragment implements View.OnClickListener{
    private RadioButton btnNew,btnExperience,btnEducation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_talent,container,false);
        initview(rootView);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        NoPosition noPosition = new NoPosition();
        transaction.replace(R.id.intalent_layout, noPosition);
        transaction.commit();

        return rootView;
    }
    private void initview(View rootView) {
        btnNew = (RadioButton) rootView.findViewById(R.id.btnNew);
        btnNew.setOnClickListener(this);
        btnExperience = (RadioButton) rootView.findViewById(R.id.btnExperience);
        btnExperience.setOnClickListener(this);
        btnEducation = (RadioButton) rootView.findViewById(R.id.btnEducation);
        btnEducation.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNew:
                break;
            case R.id.btnExperience:
                break;
            case R.id.btnEducation:
                break;
            default:
                break;


        }

    }
}
