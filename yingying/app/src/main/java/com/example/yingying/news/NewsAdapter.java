package com.example.yingying.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yingying.R;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private Context context;
    private List<News> newsList;
    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }
    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public News getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.news_item, null);
        }

        TextView news_title = convertView.findViewById(R.id.news_title);
        TextView news_date = convertView.findViewById(R.id.news_date);
        ImageView news_pic1 = convertView.findViewById(R.id.news_pic1);
        ImageView news_pic2 = convertView.findViewById(R.id.news_pic2);
        ImageView news_pic3 = convertView.findViewById(R.id.news_pic3);

        News i = newsList.get(position);
        news_title.setText(i.getNewstitle());
        news_date.setText(i.getNewsdate());


        String pic_url1 = i.getNewspic1();
        String pic_url2 = i.getNewspic2();
        String pic_url3 = i.getNewspic3();
        HttpUtils.setPicBitMap(news_pic1,pic_url1);
        HttpUtils.setPicBitMap(news_pic2,pic_url2);
        HttpUtils.setPicBitMap(news_pic3,pic_url3);

        return convertView;
    }
}
