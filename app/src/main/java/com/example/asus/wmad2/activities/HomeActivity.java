package com.example.asus.wmad2.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orm.SugarRecord;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // getSupportActionBar().setTitle("Shop");

        Gson gson=new Gson();

            if(Product.listAll(Product.class).size()<1) {
                Type listType = new TypeToken<List<Product>>() {
                }.getType();

                List<Product> products = gson.fromJson(loadJSONFromAsset(HomeActivity.this), listType);

                SugarRecord.saveInTx(products);
            }

                List<Product> productList = Product.listAll(Product.class);
                ImageAdapter ia = new ImageAdapter(this, productList);


                GridView gridview = (GridView) findViewById(R.id.gridview);
                gridview.setAdapter(ia);

       gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

            }
        });

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
}
