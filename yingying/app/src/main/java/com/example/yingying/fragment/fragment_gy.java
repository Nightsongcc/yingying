package com.example.yingying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.yingying.R;

public class fragment_gy extends Fragment {
    private View mView;
    private WebView webview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //注意View对象的重复使用，以便节省资源
        if(mView == null) {
            mView = inflater.inflate(R.layout.fragment_gy,container,false);
        }
        webview = (WebView) mView.findViewById(R.id.webview);
        webview.setScrollBarStyle(WebView.STATUS_BAR_HIDDEN );
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);

                return true;
            }

        });
        webview.loadUrl("http://music.bbbbbb.me/?name=海阔天空&type=netease");
        return mView;
    }

}
