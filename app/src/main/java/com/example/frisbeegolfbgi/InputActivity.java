package com.example.frisbeegolfbgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent intent = getIntent();

        //TextView id = (TextView) findViewById(R.id.idTextView);
        //TextView idHint = (EditText) findViewById(R.id.idHint);
        //TextView firstName = (TextView) findViewById(R.id.firstNameTextView);
        //TextView firstNameHint = (EditText) findViewById(R.id.firstNameHint);


    }
}
