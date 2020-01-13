package com.example.frisbeegolfbgi;

import androidx.appcompat.app.AppCompatActivity;
import java.sql.*;

import android.os.Bundle;
import android.os.DeadSystemException;

public class DbInsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_insert);
    }

    public static void main (String[] args) {
        try {
            String url = "jdbc.msql://192.168.43.249/tietokanta";
            Connection conn = DriverManager.getConnection(url, "root", "sellanenSalasana");
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO tietokanta'('id', 'firstName', 'lastName', 'age', 'job')"
                    + "VALUES (666, 'Kaapo', 'kolmonen', 25, 'hockey player')");

            conn.close();

        }catch (Exception e) {
            System.err.println("Error!");
            System.err.println(e.getMessage());
        }
    }
}
