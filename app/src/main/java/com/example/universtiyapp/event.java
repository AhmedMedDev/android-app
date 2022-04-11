package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class event extends AppCompatActivity {
WebView webeve;
WebSettings ws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        webeve=findViewById(R.id.webe);
        ws= webeve.getSettings();
        ws.setAllowContentAccess(true);
        ws.setJavaScriptEnabled(true);
        ws.setLoadsImagesAutomatically(true);
        ws.setAppCacheEnabled(true);

        Intent w=getIntent();
       webeve.loadUrl(w.getExtras().getString("url"));
    }
    @Override
    public void onBackPressed() {

        if(webeve.canGoBack())webeve.goBack();
        super.onBackPressed();
    }
}