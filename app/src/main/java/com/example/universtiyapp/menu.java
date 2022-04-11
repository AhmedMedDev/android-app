package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class menu extends AppCompatActivity {

    String lastEvDate;
    TextView newsAlert ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu.checkWebPage checkWebPage = new menu.checkWebPage();
        checkWebPage.execute();

        newsAlert = findViewById(R.id.newsAlert);
    }

    public void click(View v) {
        if (v.getId() == R.id.news) {
            newsAlert.setText("");
            Intent n = new Intent(this, news.class);
            n.putExtra("url", "https://science.asu.edu.eg/ar/news");
            startActivity(n);

        }
        if (v.getId() == R.id.eve) {
            Intent n = new Intent(this, event.class);
            n.putExtra("url", "https://science.asu.edu.eg/ar/events");
            startActivity(n);

        }
        if (v.getId() == R.id.adv) {
            Intent n = new Intent(this, advertisment.class);
            n.putExtra("url", "https://science.asu.edu.eg/ar/announcements");
            startActivity(n);

        }
        if (v.getId() == R.id.privatee) {
            Intent n = new Intent(this, privteads.class);
            n.putExtra("url", "https://science.asu.edu.eg/ar/announcements");
            startActivity(n);

        }
        if (v.getId() == R.id.problems) {
            Intent n = new Intent(this, problem.class);
            n.putExtra("url",
                    "https://forms.office.com/pages/responsepage.aspx?id=ZVH5axNBiEGbe8tsDBmKW-cPAmuMx6dNvjiN17RIMfRUMkRPR0xUMldPOEcwQUNFN1lKUEZLNk9XMy4u");
            startActivity(n);

        }
        if (v.getId() == R.id.fb) {
            Intent n = new Intent(this, gpaa.class);
            n.putExtra("url", "https://web.facebook.com/FacultyofScienceASU?_rdc=1&_rdr");
            startActivity(n);

        }
        if (v.getId() == R.id.gpa) {
            Intent n = new Intent(this, gpaa.class);
            n.putExtra("url", "https://gpa-calc.000webhostapp.com/");
            startActivity(n);

        }

    }

    private class checkWebPage extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids){

            lastEvDate = getLastDate();

            new Timer().scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){

                    Log.i("Check", "Check cond");
                    if (!lastEvDate.equals(getLastDate())) {
                        // Turn On Notification Alert
                        lastEvDate = getLastDate();

                        Log.i("Done", "Cond is ture");
                        newsAlert.setText("Alert");
                    }
                }
            },0,500);

            return null;
        }
    }

    public static String getLastDate () {
        try {
            Document doc = Jsoup.connect("https://github.com/AhmedMedDev").get();

            Elements elems = doc.getElementsByClass("repo");

            Element elem = elems.first();

            return elem.text();

        } catch (IOException e){
            return e.getMessage();
        }
    }
}
/**
 * - - Test Case
 *
 * Document doc = Jsoup.connect("https://github.com/AhmedMedDev").get();
 *
 * Elements elems = doc.getElementsByClass("repo");
 */