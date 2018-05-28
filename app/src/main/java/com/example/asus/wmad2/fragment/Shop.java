package com.example.asus.wmad2.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.HomeActivity;
import com.example.asus.wmad2.activities.ImageAdapter;
import com.example.asus.wmad2.models.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orm.SugarRecord;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class Shop extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Gson gson=new Gson();

        if(Product.listAll(Product.class).size()<1) {
            Type listType = new TypeToken<List<Product>>() {
            }.getType();

            List<Product> products = gson.fromJson(loadJSONFromAsset(getActivity()), listType);

            SugarRecord.saveInTx(products);
        }

        final List<Product> productList = Product.listAll(Product.class);
        ImageAdapter ia = new ImageAdapter(getActivity(), productList);

        LayoutInflater l = LayoutInflater.from(getContext());
        View view =l.inflate(R.layout.activity_home,container,false);
        GridView gridview = view.findViewById(R.id.gridview);
        gridview.setAdapter(ia);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                                          FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                          ft.replace(R.id.fMain, new Details());
                                          ft.commit();


                                          String selectedItem = parent.getItemAtPosition(position).toString();
                                          Details d = new Details();
                                          Product product = productList.get(position);

                                          String name = product.getName();

                                          String price = product.getPrice();
                                          String image = product.getFullImage();
                                          String description = product.getLongDescription();

                                          Bundle bd = new Bundle(2);
                                          bd.putString("Name" ,name);
                                          bd.putString("Price",price);
                                          bd.putString("Image",image);
                                          bd.putString("Description",description);

                                          d.setArguments(bd);
                                          android.support.v4.app.FragmentTransaction x = getActivity().getSupportFragmentManager().beginTransaction();
                                          x.replace(R.id.fMain,d);
                                          x.commit();

                                      }

        });

        return view;

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


// getSupportActionBar().setTitle("Shop");



