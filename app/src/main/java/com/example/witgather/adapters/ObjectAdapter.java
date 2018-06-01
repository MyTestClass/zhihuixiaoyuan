package com.example.witgather.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.witgather.R;
import com.example.witgather.bean.Object_Bean;
import com.example.witgather.service.file.LoadImage;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户填充ListView的适配器
 */
public class ObjectAdapter extends BaseAdapter {
    static List<Object_Bean> object_beanList = new ArrayList<Object_Bean>();
    static {
        for(int i=0;i<25;i++) {
            Object_Bean b1 = new Object_Bean();
            b1.setImageUrl("\\01.jpg");
            b1.setObjectOutPrice("123"+i);
            b1.setObjectInPrice("324");
            b1.setObjectName("ajhdfjha");
            b1.setObjectViewer("10");
            object_beanList.add(b1);
        }
    }

    /**
     * @param list 这个用户上拉刷新的，用于将数据添加在最后面
     */
    public void addObjectListLast(List<Object_Bean> list){
        object_beanList.addAll(list);
        this.notifyDataSetChanged();
    }

    /**
     * @param list 这个用于下拉刷新的，将数据添加在最前面
     */
    public void addObjectListBefore(List<Object_Bean> list){
        object_beanList.addAll(0,list);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return object_beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return object_beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.object_item_list, parent, false);
            ImageView objectImage = (ImageView) convertView.findViewById(R.id.objectImage);
            TextView objectName = (TextView) convertView.findViewById(R.id.objectName);
            TextView objectOutPrice = (TextView) convertView.findViewById(R.id.objectOutPrice);
            TextView objectInPrice = (TextView) convertView.findViewById(R.id.objectInPrice);
            TextView objectViewer = (TextView) convertView.findViewById(R.id.object_viewer);
            viewHolder = new ViewHolder();
            viewHolder.image = objectImage;
            viewHolder.objectName = objectName;
            viewHolder.objectInPrice = objectInPrice;
            viewHolder.objectOutPrice = objectOutPrice;
            viewHolder.viewCount = objectViewer;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Object_Bean b = object_beanList.get(position);
        viewHolder.objectName.setText(b.getObjectName());

//        JSONObject json1 = new JSONObject();
//            json1.put("userId", "13202355181");
//            json1.put("type", "login");
//            json1.put("password", "123456");
//            System.out.println(handler.requestForResult(json1));
//            handler.closeConnection();
//            JSONClient.shutdown();
//        从服务器上加载图片
        LoadImage loadImage = new LoadImage(viewHolder.image);
        loadImage.execute("13202355181",b.getImageUrl());
        viewHolder.objectOutPrice.setText("售价：￥"+b.getObjectOutPrice());
        viewHolder.objectInPrice.setText("原价：￥"+b.getObjectInPrice());
        viewHolder.viewCount.setText("访问量："+b.getObjectViewer());
        return convertView;
    }

    static class ViewHolder{
        public TextView objectName;
        public TextView objectInPrice;
        public ImageView image;
        public TextView objectOutPrice;
        public TextView viewCount;
    }
}

