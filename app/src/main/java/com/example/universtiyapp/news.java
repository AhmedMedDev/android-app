package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class news extends AppCompatActivity {

    WebView webnews;
    WebSettings ws;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        webnews=findViewById(R.id.webn);
        ws= webnews.getSettings();
        ws.setAllowContentAccess(true);
        ws.setJavaScriptEnabled(true);
        ws.setLoadsImagesAutomatically(true);
        ws.setAppCacheEnabled(true);
        Intent w=getIntent();
        webnews.loadUrl(w.getExtras().getString("url"));
    }
    @Override
    public void onBackPressed() {

        if(webnews.canGoBack())webnews.goBack();
        super.onBackPressed();
    }


}