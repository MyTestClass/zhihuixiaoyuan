package com.example.witgather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.witgather.R;
import com.example.witgather.bean.Express_Bean;

import java.util.ArrayList;
import java.util.List;

public class Express_List_Adapter extends BaseAdapter {
    static List<Express_Bean> express_beans = new ArrayList<>();

    static {
        for(int i=0;i<10;i++){
            Express_Bean bean = new Express_Bean();
            bean.setAddress("15栋213");
            bean.setPhoneNumber("123123");
            bean.setPrice("跑腿费：￥ 2.3");
            bean.setTime("2018-6-2 12:20");
            bean.setUserName("小陈");
            bean.setWeight("2kg");
            bean.setExpressCompanyName("中通");
            express_beans.add(bean);
        }
    }
    public void addExpress(List<Express_Bean> express_beans){
        this.express_beans.addAll(express_beans);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return express_beans.size();
    }

    @Override
    public Object getItem(int position) {
        return express_beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Express_List_Adapter.ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.express_listview_item, parent, false);
            TextView kuaidileixing = (TextView) convertView.findViewById(R.id.kuaidileixing);
            TextView songdashijian = (TextView) convertView.findViewById(R.id.songdashijian);
            TextView songdadidian = (TextView) convertView.findViewById(R.id.songdadidian);
            TextView expressprice = (TextView) convertView.findViewById(R.id.expressprice);
            TextView dagaizhongliang = (TextView) convertView.findViewById(R.id.dagaizhongliang);
            viewHolder = new Express_List_Adapter.ViewHolder();
            viewHolder.kuaidileixing = kuaidileixing;
            viewHolder.songdashijian = songdashijian;
            viewHolder.songdadidian = songdadidian;
            viewHolder.expressprice = expressprice;
            viewHolder.dagaizhongliang = dagaizhongliang;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Express_List_Adapter.ViewHolder) convertView.getTag();
        }
        Express_Bean b = express_beans.get(position);
        viewHolder.dagaizhongliang.setText(b.getWeight());
        viewHolder.expressprice.setText(b.getPrice());
        viewHolder.songdadidian.setText(b.getAddress());
        viewHolder.songdashijian.setText(b.getTime());
        viewHolder.kuaidileixing.setText(b.getExpressCompanyName());
        return convertView;
    }
    static class ViewHolder{
        public TextView kuaidileixing;
        public TextView songdashijian;
        public TextView songdadidian;
        public TextView expressprice;
        public TextView dagaizhongliang;
    }
}
