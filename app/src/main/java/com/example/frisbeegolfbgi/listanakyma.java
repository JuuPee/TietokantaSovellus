package com.example.frisbeegolfbgi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

public class listanakyma extends AppCompatActivity{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listanakyma);

        textView = (TextView) findViewById(R.id.textView);

        String allInfo = getIntent().getStringExtra("allInfo");

        textView.setText(allInfo);

    }


    }






