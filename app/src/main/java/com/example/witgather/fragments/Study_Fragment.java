package com.example.witgather.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.witgather.R;

public class Study_Fragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;
    private Study_Question_Publish_Fragment question_publish_fragment = null;
    private Study_Question_Search_Fragment question_search_fragment = null;
    private Study_Data_Upload_Fragment data_upload_fragment = null;
    private Study_Data_Load_Fragment data_load_fragment = null;
    private Fragment currentFragment=null;
    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.study_fragment_layout,container,false);
        radioGroup = (RadioGroup)view.findViewById(R.id.study_fragment_radio_button);
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getChildFragmentManager();

        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        question_search_fragment = new Study_Question_Search_Fragment();
        transaction.add(R.id.study_fragment_content,question_search_fragment);
        currentFragment = question_search_fragment;
        transaction.show(currentFragment);
        transaction.commit();
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        transaction.hide(currentFragment);
        if(checkedId==R.id.study_question_search){
            if(question_search_fragment==null){
                question_search_fragment = new Study_Question_Search_Fragment();
                transaction.add(R.id.study_fragment_content,question_search_fragment);
            }
            currentFragment = question_search_fragment;
        }else if(checkedId==R.id.study_question_publish){
            if(question_publish_fragment==null){
                question_publish_fragment = new Study_Question_Publish_Fragment();
                transaction.add(R.id.study_fragment_content,question_publish_fragment);
            }
            currentFragment =question_publish_fragment;
        }else if(checkedId==R.id.study_question_studydata_search){

        }else if(checkedId==R.id.study_question_studydata_upload){

        }
        transaction.show(currentFragment);
        transaction.commit();
    }
}
