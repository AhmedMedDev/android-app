package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class problem extends AppCompatActivity {


    WebView webp;
    WebSettings ws;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        webp=findViewById(R.id.webproblem);

        ws= webp.getSettings();
       ws.setAllowContentAccess(true);
        ws.setJavaScriptEnabled(true);
        ws.setLoadsImagesAutomatically(true);
        ws.setAppCacheEnabled(true);

        Intent w=getIntent();
        webp.loadUrl(w.getExtras().getString("url"));
    }
    @Override
    public void onBackPressed() {

        if(webp.canGoBack())webp.goBack();
        super.onBackPressed();
    }
}