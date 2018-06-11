package com.example.asus.wmad2.activities;


import android.app.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.example.asus.wmad2.fragment.Details;
import com.example.asus.wmad2.fragment.HomeFragment;
import com.example.asus.wmad2.fragment.PurchaseFragment;
import com.example.asus.wmad2.models.Favorite;
import com.example.asus.wmad2.models.Orders;
import com.squareup.picasso.Picasso;

import java.util.List;

public class favAdapter extends ArrayAdapter<Favorite> {


    private LayoutInflater inflater;
    private Context context;
   Favorite o;
   Button vp;





    public favAdapter(@NonNull Context context, @NonNull List<Favorite> objects) {
        super(context, R.layout.favcustom, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //("ViewHolder") View view= minflater.inflate(R.)

        final Favorite o = getItem(position);
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.favcustom, parent, false);

        Button button = view.findViewById(R.id.button2);
        Button vp= view.findViewById(R.id.btnvp);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(o);
              //  o.setStatus("removed");
                o.save();

            }
        });

        vp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   FragmentManager manager= (Activity)context.getFragmentManager();
               // FragmentManager fragmentManager= ((Activity)context).getFragmentManager();
              //  FragmentTransaction fr = fragmentManager.beginTransaction();
               // fr.replace(R.id.fMain,new Details());
                //fr.commit();


            }
        });

        TextView textView1 = view.findViewById(R.id.textView25);
        TextView textView2 = view.findViewById(R.id.textView26);
       // TextView textView3 = view.findViewById(R.id.textView27);
        ImageView imageview = view.findViewById(R.id.imageView7);

        try {
            textView1.setText(o.getProduct().getName());
            textView2.setText(String.valueOf(o.getProduct().getPrice()));
           // textView3.setText(String.valueOf(o.getProduct().getQuantity()));
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


