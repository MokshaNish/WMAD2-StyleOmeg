package com.example.asus.wmad2.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.Product;
import com.example.asus.wmad2.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orm.SugarRecord;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class splash extends AppCompatActivity {
//private static int SPLASH_TIME_OUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread t = new Thread() {
            SharedPreferences preferences = getSharedPreferences("User Details", MODE_PRIVATE);

            public void run() {
                try {
                    sleep(5000);
                    String value = preferences.getString("id", "");
                    if (value.length() == 0) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent intent = new Intent(splash.this, NavigationActivity.class);
                        startActivity(intent);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        };

        t.start();

        ArrayList<Product> productList = (ArrayList<Product>)Product.listAll(Product.class);
        if (productList.isEmpty())

        {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Product>>() {
            }.getType();

            List<Product> products = gson.fromJson(loadJSONFromAsset(getApplicationContext()), listType);

            SugarRecord.saveInTx(products);


        }
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Product.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }


        // new Handler().postDelayed(new Runnable(){

          //  @Override
            //public void run() {
           //Intent intent = new Intent(splash.this,MainActivity.class);
           //startActivity(intent);
           //finish();
            }
        //},SPLASH_TIME_OUT);



