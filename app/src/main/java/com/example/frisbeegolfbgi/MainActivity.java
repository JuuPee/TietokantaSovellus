package com.example.frisbeegolfbgi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements Serializable {

    ListView listView;
    int limit = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        downloadJSON("http://192.168.43.249/android_connect/api/management_service.php"); //EO LOCALHOSTIA!!!!


    }

    private void downloadJSON(final String urlWebService) {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext (), "Success", Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {

                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return "paskaa";
                }
            }

        }
        DownloadJSON getJSON = new DownloadJSON();
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.HONEYCOMB)
            getJSON.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else
            getJSON.execute();

    }


    @SuppressWarnings("deprecation")
        private void loadIntoListView(final String json) throws JSONException {
        final JSONArray jsonArray = new JSONArray(json);
        final String[] nameInfo = new String[jsonArray.length()];
        final String[] info = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            nameInfo[i] = obj.getString("firstName") + " " + obj.getString("lastName");
            info[i] = obj.getString("id") + "    " + obj.getString("firstName") + " " + obj.getString("lastName") + " \n"
                    + obj.getString("age") + " " + obj.getString("job") + " \n";

        }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameInfo);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, listanakyma.class);

                intent.putExtra("allInfo", Arrays.toString(info));

                startActivity(intent);

            }
        });
   }

   public void moveToInput (View view) {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    public void deletingData (View view) {
        Intent intent = new Intent(this, checkBoxActivity.class);
        startActivity(intent);

    }
    public int getCount() {
        return limit;
    }
}