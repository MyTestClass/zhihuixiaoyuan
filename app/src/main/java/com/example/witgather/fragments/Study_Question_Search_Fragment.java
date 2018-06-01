package com.example.witgather.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.witgather.R;
import com.example.witgather.adapters.Question_List_Adapter;

public class Study_Question_Search_Fragment extends Fragment {
    private Question_List_Adapter list_adapter = new Question_List_Adapter();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.study_questionsearch_fragment_layout,container,false);
        ListView listView = (ListView) view.findViewById(R.id.study_question_list);
        listView.setAdapter(list_adapter);
        return view;
    }
}
