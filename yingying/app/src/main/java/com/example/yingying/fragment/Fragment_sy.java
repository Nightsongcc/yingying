package com.example.yingying.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yingying.R;
import com.example.yingying.news.NewsAdapter;
import com.example.yingying.news.HttpUtils;
import com.example.yingying.news.News;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Fragment_sy extends Fragment {
    private View mView;
    private ListView listview;
    private NewsAdapter adapter;
    private List<News>  newsList;

    public static final String GET_NEWS_URL = "https://nightsong.cc/test/";


    public Handler getNewsHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            String jsonData = (String) msg.obj;
            System.out.println(jsonData);
            try{
                JSONArray jsonArray = new JSONArray(jsonData);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject j = jsonArray.getJSONObject(i);
                    String title = j.getString("title");
                    String date = j.getString("date");
                    String newsurl = j.getString("url");
                    String pic1 = j.getString("thumbnail_pic_s");
                    String pic2 = j.getString("thumbnail_pic_s02");
                    String pic3 = j.getString("thumbnail_pic_s03");

                    newsList.add(new News(title,date,newsurl,pic1,pic2,pic3));
                    System.out.println(newsList.get(i).getNewstitle().toString());
                    adapter.notifyDataSetChanged();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        };
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //注意View对象的重复使用，以便节省资源
        if(mView == null) {
            mView = inflater.inflate(R.layout.fragment_sy,container,false);
        }
        newsList = new ArrayList<News>();
        listview = (ListView)mView.findViewById(R.id.news_view);

        adapter = new NewsAdapter(mView.getContext(), newsList);

        listview.setAdapter(adapter);

        HttpUtils.getNewsJSON(GET_NEWS_URL, getNewsHandler);
        return mView;
    }



}
