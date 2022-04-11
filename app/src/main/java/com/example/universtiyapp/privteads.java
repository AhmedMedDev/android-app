package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class privteads extends AppCompatActivity {
    WebView webadd;
    WebSettings ws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privteads);
       webadd=findViewById(R.id.webp);

        ws= webadd.getSettings();
        ws.setAllowContentAccess(true);
        ws.setJavaScriptEnabled(true);
        ws.setLoadsImagesAutomatically(true);
        ws.setAppCacheEnabled(true);
       Intent w=getIntent();
       webadd.loadUrl(w.getExtras().getString("url"));
    }
    @Override
    public void onBackPressed() {

        if(webadd.canGoBack())webadd.goBack();
        super.onBackPressed();
    }
}