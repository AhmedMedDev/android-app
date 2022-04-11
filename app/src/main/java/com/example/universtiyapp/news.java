package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class news extends AppCompatActivity {

    WebView webnews;
    WebSettings ws;
    TextView txv1;
    String lastEvDate;
//    Button news ;

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

        checkWebPage checkWebPage = new checkWebPage();
        checkWebPage.execute();

//        news.findViewById(R.id.news);
    }
    @Override
    public void onBackPressed() {

        if(webnews.canGoBack())webnews.goBack();
        super.onBackPressed();
    }

    private class checkWebPage extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids){

                lastEvDate = getLastDate();

                new Timer().scheduleAtFixedRate(new TimerTask(){
                    @Override
                    public void run(){

                        if (!lastEvDate.equals(getLastDate())) {
                            // Turn On Notification Alert
//                            news.setText("Alert");
                        }
                    }
                },0,5000);

            return null;
        }
    }

    public static String getLastDate () {
        try {
            Document doc = Jsoup.connect("https://science.asu.edu.eg/ar/events").get();

            Elements elems = doc.getElementsByClass("event-date");

            Element elem = elems.first();

            return elem.text();

        } catch (IOException e){
            return e.getMessage();
        }
    }
}