package com.example.android_mid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView1 = (WebView) findViewById(R.id.webview1);

        webView1.setWebViewClient(new WebViewClient());

        WebSettings webSetting = webView1.getSettings();
        webSetting.setJavaScriptEnabled(true);

        webSetting.setAllowContentAccess(true);
        webSetting.setLoadWithOverviewMode(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setLoadsImagesAutomatically(true);
        webSetting.setAppCacheEnabled(true);

//        webSetting.setMixedContentMode (WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//
//        checkWebPage cwp= new checkwebPage();
//        cwp.execute();
//        txv1 = (TextView) findViewById (R.id.txv1);
//        else if(view.getId()==R.id.RSugg) {
//            webView1.loadUrl("https://forms.office.com/r/HfejjtfynN");
//        }
    }

    public void changeWebPage(View view) {
        if (view.getId() == R.id.REvents) {
            webView1.loadUrl("https://science.asu.edu.eg/ar/events");
        } else if (view.getId() == R.id.RNews) {
            webView1.loadUrl("https://science.asu.edu.cg/ar/news");
        }
    }

    @Override
    public void onBackPressed() {
        if (webView1.canGoBack()) webView1.goBack();
        else super.onBackPressed();
    }
}