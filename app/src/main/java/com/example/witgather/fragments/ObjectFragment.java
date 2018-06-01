package com.example.witgather.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.witgather.R;
import com.example.witgather.adapters.ObjectAdapter;
import com.example.witgather.bean.Object_Bean;

import java.util.ArrayList;
import java.util.List;

public class ObjectFragment extends Fragment {
    private View headerView;
    private int headerViewHeight;
    private ImageView headerImage;
    private TextView headerText;
    private View footerView;
    private int footerViewHeight;
    /**
     * 按下时的Y坐标
     */
    private int downY;

    private static final int PULL_REFRESH = 0;//下拉刷新的状态
    private static final int RELEASE_REFRESH = 1;//松开刷新的状态
    private static final int REFRESHING = 2;//正在刷新的状态

    /**
     * 当前下拉刷新处于的状态
     */
    private int currentState = PULL_REFRESH;

    /**
     * 当前是否在加载数据
     */
    private boolean isLoadingMore = false;

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.object_fragment,container,false);
        ListView listView = (ListView) view.findViewById(R.id.objectList);
        ObjectAdapter objectAdapter = new ObjectAdapter();
//        将列表和视图解析器绑定
        listView.setAdapter(objectAdapter);

        return view;
    }
    private void initListView(ListView listView){

    }

}
