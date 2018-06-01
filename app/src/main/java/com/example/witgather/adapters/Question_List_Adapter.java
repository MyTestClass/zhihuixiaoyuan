package com.example.witgather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.witgather.R;
import com.example.witgather.bean.Question_Bean;

import java.util.ArrayList;
import java.util.List;

public class Question_List_Adapter extends BaseAdapter {
    private static List<Question_Bean> question_beanList = new ArrayList<Question_Bean>();
    static {
        for(int i=0;i<20;i++){
            Question_Bean b = new Question_Bean();
            b.setSubject("C语言");
            b.setQuestionTitle("函数指针和指针函数的区别");
            b.setAnswerCount("10");
            b.setIsSolve("未解决");
            b.setQuestionPrice("3");
            question_beanList.add(b);
        }
    }

    public void addAnswerList(List<Question_Bean> question_beanList){
        question_beanList.addAll(question_beanList);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return question_beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return question_beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question_List_Adapter.ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.study_question_list_item, parent, false);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.questionImage);
            TextView subject = (TextView)convertView.findViewById(R.id.question_subject);
            TextView title = (TextView)convertView.findViewById(R.id.question_title);
            TextView price = (TextView)convertView.findViewById(R.id.question_price);
            TextView isSolve = (TextView)convertView.findViewById(R.id.question_is_solve);
            TextView answerCount= (TextView)convertView.findViewById(R.id.question_answer_count);
            holder = new Question_List_Adapter.ViewHolder();
            holder.imageView = imageView;
            holder.subject = subject;
            holder.title = title;
            holder.price = price;
            holder.isSolve = isSolve;
            holder.answerCount = answerCount;
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Question_Bean bean = question_beanList.get(position);
        holder.subject.setText(bean.getSubject());
        holder.title.setText(bean.getQuestionTitle());
        holder.price.setText(bean.getQuestionPrice());
        holder.isSolve.setText(bean.getIsSolve());
        holder.answerCount.setText(bean.getAnswerCount());
        return convertView;
    }
    static class ViewHolder{
        public ImageView imageView;
        public TextView subject;
        public TextView title;
        public TextView price;
        public TextView isSolve;
        public TextView answerCount;
    }
}
