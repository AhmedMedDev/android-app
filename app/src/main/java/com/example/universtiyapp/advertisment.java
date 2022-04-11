package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class advertisment extends AppCompatActivity {
WebView webad;
WebSettings ws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisment);
        webad=findViewById(R.id.webadv);

        ws= webad.getSettings();
        ws.setAllowContentAccess(true);
        ws.setJavaScriptEnabled(true);
        ws.setLoadsImagesAutomatically(true);
        ws.setAppCacheEnabled(true);
        Intent w=getIntent();
        webad.loadUrl(w.getExtras().getString("url"));
    }

    @Override
    public void onBackPressed() {

        if(webad.canGoBack())webad.goBack();
        super.onBackPressed();
    }
}