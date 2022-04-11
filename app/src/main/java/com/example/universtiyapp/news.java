package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Timer;
import java.util.TimerTask;

public class news extends AppCompatActivity {

    WebView webnews;
    WebSettings ws;
    TextView txv1;
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

        txv1 = findViewById(R.id.txv1);

        checkWebPage checkWebPage = new checkWebPage();
        checkWebPage.execute();
//        txv1. setText("aaaaaa");

    }
    @Override
    public void onBackPressed() {

        if(webnews.canGoBack())webnews.goBack();
        super.onBackPressed();
    }

    private class checkWebPage extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids){
                new Timer().scheduleAtFixedRate(new TimerTask(){
                    @Override
                    public void run(){
                        try {

                            Document doc = Jsoup.connect("https://science.asu.edu.eg/ar/events").get();
                            Elements elems = doc.getElementsByClass("event-date");
                            Element elem = elems.first();
                            String stEvent = elem.text();
                            String oldEvent = elem.text();
                            txv1. setText(stEvent);
                            if (stEvent.equals(oldEvent)) txv1. setText("New Enent");

                        } catch (IOException e){

                        }
                    }
                },0,5000);

            return null;
        }
    }

}