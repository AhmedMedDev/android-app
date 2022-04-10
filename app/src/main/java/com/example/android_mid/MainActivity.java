package com.example.android_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView1 = (WebView) findViewById(R.id.webview1);
    }

    public void changeWebPage(View view) {
        if (view.getId() == R.id.REvents) {
            webView1.loadUrl("https://science.asu.edu.eg/ar/events");
        } else if (view.getId() == R.id.RNews) {
            webView1.loadUrl("https://science.asu.edu.cg/ar/news");
        }
    }

    }