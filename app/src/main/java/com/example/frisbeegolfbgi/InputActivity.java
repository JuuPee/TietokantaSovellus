package com.example.frisbeegolfbgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent intent = getIntent();

        final EditText idHint, first_name_hint,last_name_hint, job_hint;
        Button save;


        idHint = (EditText) findViewById(R.id.idHint);
        first_name_hint = (EditText) findViewById(R.id.FirstNameHint);
        last_name_hint = (EditText) findViewById(R.id.lastNameHint);
        job_hint = (EditText) findViewById(R.id.jobHint);


        save = (Button) findViewById(R.id.buttonSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String id = idHint.getText().toString();
                    String firstName = first_name_hint.getText().toString();
                    String lastName = last_name_hint.getText().toString();
                    String job = job_hint.getText().toString();

                    System.out.println(id + " " + firstName + " " + lastName + " " + job);



                }
                catch (Exception e) {
                    System.out.println(e + "error");

                }

            }
        });

    }
}
