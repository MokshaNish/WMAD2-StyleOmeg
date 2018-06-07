package com.example.asus.wmad2.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.Orders;
import com.example.asus.wmad2.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;


public class CartAdapter extends ArrayAdapter<Orders> {

    Button remove;
    private LayoutInflater inflater;
    private Context context;
    Orders o;





    public CartAdapter(@NonNull Context context, @NonNull List<Orders> objects) {
        super(context, R.layout.cartlayout, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //("ViewHolder") View view= minflater.inflate(R.)

        final Orders o = getItem(position);
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.cartlayout, parent, false);

        Button button = view.findViewById(R.id.removebtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(o);
                o.setStatus("removed");
                o.save();

            }
        });


        TextView textView1 = view.findViewById(R.id.textView5);
        TextView textView2 = view.findViewById(R.id.textView6);
        TextView textView3 = view.findViewById(R.id.textView8);
        ImageView imageview = view.findViewById(R.id.imageView3);

        try {
            textView1.setText(o.getProduct().getName());
            textView2.setText(String.valueOf(o.getProduct().getPrice()));
            textView3.setText(String.valueOf(o.getProduct().getQuantity()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
           // imageview.setImageResource(R.drawable.ic_launcher);


            Picasso.get()
                    .load(o.getProduct().getScaledImage())
                    .placeholder(R.drawable.ic_launcher)
                    .resize(300, 400)
                    .into(imageview);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;


    }

}


