package com.example.frisbeegolfbgi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class checkBoxActivity extends AppCompatActivity {

    CheckBox  jee, jihuu;
    Button poista;

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
    }

    public void addListenerOnButton() {
        jee = (CheckBox) findViewById(R.id.jees);
        jihuu = (CheckBox) findViewById(R.id.jihuuu);
        poista = (Button) findViewById(R.id.buttonDelete);

        poista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("jee").append(jee.isChecked());
                result.append("jihuu").append(jihuu.isChecked());

                Toast.makeText(checkBoxActivity.this, result.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
