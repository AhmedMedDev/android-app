package com.example.universtiyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES. LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.medB));
        }
    }

    public void start(View v){

       Intent i=new Intent(this, menu.class );
startActivity(i);


    }





}