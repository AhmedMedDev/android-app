package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
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


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("event notification", "event channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    public void click(View v) {
        if (v.getId() == R.id.news) {
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
            n.putExtra("url", "https://ahmedmeddev.github.io/GPA-Calculator/");
            startActivity(n);

        }

    }

    private class checkWebPage extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids){

            lastEvDate = getLastDate(); // Node-NoSQL-Auth

//            new Timer().scheduleAtFixedRate(new TimerTask(){
//                @Override
//                public void run(){
//
//                    String newDate = getLastDate();
//
//                    if (!lastEvDate.equals(newDate)) {
//
//                        lastEvDate = newDate;
//                        // Fire Notification
////                        NotificationCompat.Builder builder = new NotificationCompat.Builder(menu.this, "event notification");
////                        builder.setContentTitle("New Event");
////                        builder.setContentText("Event description");
////                        builder.setAutoCancel(true);
////
////                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(menu.this);
////                        managerCompat.notify(1, builder.build());
//                    }
//                }
//            },0,500);

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

    public void triggerNotification () {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(menu.this, "My Notification");
        builder.setContentTitle("New Event");
        builder.setContentText("Event description");
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(menu.this);
        managerCompat.notify(1, builder.build());
    }
}
/**
 * - - Test Case
 *
 * Document doc = Jsoup.connect("https://github.com/AhmedMedDev").get();
 *
 * Elements elems = doc.getElementsByClass("repo");
 */