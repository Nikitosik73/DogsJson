package com.example.dogsonlineimage;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://dog.ceo/api/breeds/image/random";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadDogImage();
    }

    private void loadDogImage() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(BASE_URL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String result;

                    StringBuilder data = new StringBuilder();
                    do {
                        result = bufferedReader.readLine();
                        if (result != null) {
                            data.append(result);
                        }
                    } while (result != null);

                    JSONObject jsonObject = new JSONObject(data.toString());
                    String status =  jsonObject.getString("status");
                    String message = jsonObject.getString("message");

                    DogImage dogImage = new DogImage(status, message);

                    Log.d("MainActivity", dogImage.toString());
                } catch (Exception e) {
                    Log.d("MainActivity", e.toString());
                }
            }
        }).start();
    }
}