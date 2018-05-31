package com.example.asus.wmad2.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.NavigationActivity;
import com.example.asus.wmad2.models.Orders;
import com.example.asus.wmad2.models.Product;
import com.example.asus.wmad2.models.User;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class Details extends Fragment {

Button sharebtn;
Button addtocart;
Orders orders;
    Long i  ;
    TextView text1;
    String id;
    TextView text3;
    TextView text4;
    ImageView image;

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((NavigationActivity) getActivity()).setActionBarTitle("Detail Screen");

        LayoutInflater l = LayoutInflater.from(getContext());
        SharedPreferences preferences= this.getActivity().getApplication().getSharedPreferences("User Details", Context.MODE_PRIVATE);
         id = preferences.getString("id","");
        View view = l.inflate(R.layout.detailcustom, container, false);


            android.support.v4.app.Fragment fragment = new Details();



        try {

            Bundle bundle = getArguments();


            String q = bundle.getString("Name");
            double m = bundle.getDouble("Price");
            String n = bundle.getString("Image");
            String o = bundle.getString("Description");
            i = bundle.getLong("id");
        } catch (Exception e) {
            e.printStackTrace();
        }


         text1 =  view.findViewById(R.id.textViewds2);
            text3 =  view.findViewById(R.id.textViewds1);
            text4 = view.findViewById(R.id.textViewds3);
            image = view.findViewById(R.id.detailcustomimageView);


        final Product pro = Product.findById(Product.class ,i);
            final User use = User.findById(User.class, Long.parseLong(id));

        try {

            text1.setText(String.valueOf(pro.getPrice()));
            text3.setText(pro.getName());
            text4.setText(pro.getLongDescription());
            Picasso.get()
                    .load(pro.getScaledImage())
                    .placeholder(R.drawable.ic_launcher)
                    .into(image);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Inflate the layout for this fragment
        sharebtn = view.findViewById(R.id.buttonshare);

        sharebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "MY NEW APP");


                share.putExtra(Intent.EXTRA_TEXT, " Try my new app:");
                startActivity(Intent.createChooser(share, "Share Via"));

            }
        });

            addtocart = (Button)view.findViewById(R.id.buttonaddtocart);

            addtocart.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  orders = new Orders();
                  orders.setProduct(pro);
                  orders.setUser(use);
                  orders.setStatus("Pending");
                  orders.save();

              }
          });




      //  Toast.makeText(getActivity(),"Add to cart",Toast.LENGTH_SHORT).show();
        return view;

        }}
