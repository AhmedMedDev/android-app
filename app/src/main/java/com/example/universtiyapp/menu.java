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
    String channelId="chId";
    int notificationID = 1;
    String Not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu.checkWebPage checkWebPage = new menu.checkWebPage();
        checkWebPage.execute();
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

            lastEvDate = getLastItem("https://github.com/AhmedMedDev", "repo"); // Node-NoSQL-Auth

            new Timer().scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run(){

                    String newDate = getLastItem("https://github.com/AhmedMedDev", "repo");

                    if (!lastEvDate.equals(newDate) && !newDate.equals("Error")) {
                        lastEvDate = newDate;
                        // Fire Notification
                        triggerNotification("New Event", "New event with date : " + newDate);
                    }
                }
            },0,1000);

            return null;
        }
    }

    void triggerNotification(String title, String content){
        creatChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channelId);
        builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(R.drawable.ic_launcher_background);
        NotificationManagerCompat NMC = NotificationManagerCompat.from(this);
        ++notificationID;
        NMC.notify(notificationID,builder.build());
    }

    void creatChannel (){
        NotificationChannel NC = new NotificationChannel(channelId,"My Notification", NotificationManager.IMPORTANCE_DEFAULT);
        NC.setDescription("Get Notification");
        NotificationManager NMG = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NMG.createNotificationChannel(NC);
    }

    public static String getLastItem (String url, String className) {
        try {
            Document doc = Jsoup.connect(url).get();

            Elements elems = doc.getElementsByClass(className);

            Element elem = elems.first();

            return elem.text();

        } catch (IOException e){
            return "Error";
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