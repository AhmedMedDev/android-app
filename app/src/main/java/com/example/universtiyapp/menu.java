package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

public void click(View v){
        if(v.getId()==R.id.news){
            Intent n=new Intent(this,news.class);
            n.putExtra("url","https://science.asu.edu.eg/ar/news");
startActivity(n);

        }
 if(v.getId()==R.id.eve){
            Intent n=new Intent(this,event.class);
            n.putExtra("url","https://science.asu.edu.eg/ar/events");
            startActivity(n);


        }
    if(v.getId()==R.id.adv){
        Intent n=new Intent(this,advertisment.class);
        n.putExtra("url","https://science.asu.edu.eg/ar/announcements");
        startActivity(n);


    }
    if(v.getId()==R.id.privatee){
        Intent n=new Intent(this,privteads.class);
        n.putExtra("url","https://science.asu.edu.eg/ar/announcements");
        startActivity(n);


    }
    if(v.getId()==R.id.problems){
        Intent n=new Intent(this,problem.class);
        n.putExtra("url","https://forms.office.com/pages/responsepage.aspx?id=ZVH5axNBiEGbe8tsDBmKW-cPAmuMx6dNvjiN17RIMfRUMkRPR0xUMldPOEcwQUNFN1lKUEZLNk9XMy4u");
        startActivity(n);


    }
    if(v.getId()==R.id.fb){
        Intent n=new Intent(this,gpaa.class);
        n.putExtra("url","https://web.facebook.com/FacultyofScienceASU?_rdc=1&_rdr");
        startActivity(n);


    }
    if(v.getId()==R.id.gpa){
        Intent n=new Intent(this,gpaa.class);
        n.putExtra("url","https://gpa-calc.000webhostapp.com/");
        startActivity(n);


    }


}

}