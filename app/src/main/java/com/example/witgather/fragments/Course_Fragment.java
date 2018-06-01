package com.example.witgather.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.witgather.R;
import com.example.witgather.bean.Course_Bean;

import java.util.ArrayList;
import java.util.List;

public class Course_Fragment extends Fragment {
    int color_Array[]={R.color.course1,R.color.course2,R.color.course3,R.color.course4,R.color.course5,
            R.color.course6,R.color.course7,R.color.course8,R.color.course9,R.color.course10
    };
//这里是模拟测试的数据
    private static List<Course_Bean> course_beans = new ArrayList<>();
    static {
        Course_Bean courseBean = new Course_Bean();
        courseBean.setCourse_name("高等数学");
        courseBean.setCourse_place("一教");
        courseBean.setLength(2);
        courseBean.setColorId(0);
        courseBean.setStart_position(1);

        Course_Bean courseBean1 = new Course_Bean();
        courseBean1.setCourse_name("网络规划");
        courseBean1.setCourse_place("实验楼");
        courseBean1.setStart_position(7);
        courseBean1.setLength(2);
        courseBean1.setColorId(4);
        course_beans.add(courseBean);
        course_beans.add(courseBean1);
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.course_main,container,false);
        LinearLayout monday = (LinearLayout) rootView.findViewById(R.id.monday);
        aDayCourse(monday,course_beans);
        return rootView;
    }

    private void aDayCourse(LinearLayout rootView,List<Course_Bean> list){
//      代表的是当前列的目前填充的位置
        for(int i=1;i<=12;){
            if(!list.isEmpty()){
                Course_Bean courseBean = list.remove(0);
                if(courseBean.getStart_position()!=i){
                    LinearLayout empty = new LinearLayout(rootView.getContext());
                    LinearLayout.LayoutParams empty_Params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,0);
                    empty_Params.weight=courseBean.getStart_position()-i;
                    empty.setLayoutParams(empty_Params);
                    rootView.addView(empty);
                    i=courseBean.getStart_position();
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,0);

                layoutParams.weight = courseBean.getLength();
//                最左边一列和右边一列的特殊处理
                if(rootView.getId()==R.id.monday)
                    layoutParams.setMargins(0,0,6,6);
                else if(rootView.getId()==R.id.sunday)
                    layoutParams.setMargins(6,0,0,6);
                else
                    layoutParams.setMargins(6,0,6,6);

                LinearLayout linearLayout = new LinearLayout(rootView.getContext());

                linearLayout.setBackgroundColor(getColor(courseBean.getColorId()));
//                课程的名字
                TextView courseName = new TextView(rootView.getContext());
                courseName.setText(courseBean.getCourse_name());
                courseName.setTextColor(getResources().getColor(R.color.courseName));
                courseName.setTextSize(16);
                courseName.setGravity(Gravity.CENTER);

//                课程的教室
                TextView coursePlace = new TextView(rootView.getContext());
                coursePlace.setText(courseBean.getCourse_place());
                coursePlace.setTextColor(getResources().getColor(R.color.courseName));
                coursePlace.setGravity(Gravity.CENTER);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.addView(courseName);
                linearLayout.addView(coursePlace);
                i=i+courseBean.getLength();
                linearLayout.setLayoutParams(layoutParams);
                rootView.addView(linearLayout);
            }else{
                LinearLayout empty = new LinearLayout(rootView.getContext());
                LinearLayout.LayoutParams empty_Params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,0);
                empty_Params.weight=12-i+1;
                empty.setLayoutParams(empty_Params);
                rootView.addView(empty);
                break;
            }
        }
    }
    public List<Course_Bean> getCourse_beans() {
        return course_beans;
    }

    public void setCourse_beans(List<Course_Bean> course_beans) {
        this.course_beans = course_beans;
    }

    private int getColor(int colorId){
        return getResources().getColor(color_Array[colorId]);
    }
}
