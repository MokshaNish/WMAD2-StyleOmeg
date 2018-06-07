package com.example.asus.wmad2.activities;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.OrderItems;
import com.example.asus.wmad2.models.Orders;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<OrderItems>{
    OrderItems o;
    Button cancel;

    TextView d;




    public HistoryAdapter(@NonNull Context context, @NonNull List<OrderItems> objects) {
        super(context, R.layout.historycustom, objects);
    }

    @Override
    @NonNull

    public View getView(int position, View convertView, ViewGroup parent) {


            o = getItem(position);
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            View view = layoutInflater.inflate(R.layout.historycustom, parent, false);

            Button cancel = view.findViewById(R.id.btncancel);
         // d= view.findViewById(R.id.textView24);
        final OrderItems oi = new OrderItems();



        cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(o);
                    o.save();
                }
            });


        final List<OrderItems> asd= OrderItems.listAll(OrderItems.class);

            TextView textView1 = view.findViewById(R.id.textView9);
            TextView textView2 = view.findViewById(R.id.textView19);
            TextView textView3 = view.findViewById(R.id.textView22);
            ImageView imageview = view.findViewById(R.id.imageView6);

        try {
            textView1.setText(o.getOrders().getProduct().getName());
            textView2.setText(String.valueOf(o.getOrders().getProduct().getPrice()));
            textView3.setText(String.valueOf(o.getOrders().getProduct().getQuantity()));
           // d.setText(String.valueOf(oi.getDate()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        // imageview.setImageResource(R.drawable.ic_launcher);


        try {
            Picasso.get()
                    .load(o.getOrders().getProduct().getScaledImage())
                    .placeholder(R.drawable.ic_launcher)
                    .resize(300, 400)
                    .into(imageview);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;


        }

    }



