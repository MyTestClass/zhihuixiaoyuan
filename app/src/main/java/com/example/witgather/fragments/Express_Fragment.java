package com.example.witgather.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.witgather.R;

/**
 * 快递处理的Fragment，这里面还包含两个子Fragment
 */
public class Express_Fragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private Publish_Express_Fragment publish_express_fragment=null;
    private Get_Express_Fragment get_express_fragment=null;
    private Fragment currentFragment=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.express_fragment,container,false);

        radioGroup = (RadioGroup)view.findViewById(R.id.express_radio_button);
        radioGroup.setOnCheckedChangeListener(this);
        fragmentManager = getChildFragmentManager();
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        publish_express_fragment = new Publish_Express_Fragment();
        currentFragment = publish_express_fragment;
        transaction.add(R.id.express_content,publish_express_fragment);
        transaction.show(currentFragment);
        transaction.commit();
        return view;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction =  fragmentManager.beginTransaction();
        if(checkedId==R.id.publish_express_radio_button){
            if(publish_express_fragment==null){
                publish_express_fragment = new Publish_Express_Fragment();
                transaction.add(R.id.express_content,publish_express_fragment);
            }
            transaction.hide(currentFragment);
            currentFragment = publish_express_fragment;
            transaction.show(publish_express_fragment);
        }else if(checkedId==R.id.get_express_radio_button){
            if(get_express_fragment==null){
                get_express_fragment = new Get_Express_Fragment();
                transaction.add(R.id.express_content,get_express_fragment);
            }
            transaction.hide(currentFragment);
            currentFragment = get_express_fragment;
            transaction.show(get_express_fragment);
        }
        transaction.commit();
    }
}
