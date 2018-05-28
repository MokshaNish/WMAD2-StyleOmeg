package com.example.asus.wmad2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.NavigationActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class Details extends Fragment {

Button sharebtn;
Button addtocart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((NavigationActivity) getActivity()).setActionBarTitle("Detail Screen");

        LayoutInflater l = LayoutInflater.from(getContext());
        View view = l.inflate(R.layout.detailcustom, container, false);

        try {
            android.support.v4.app.Fragment fragment = new Details();
            Bundle bundle = getArguments();

            String q = bundle.getString("Name");
            String m = bundle.getString("Price");
            String n = bundle.getString("Image");
            String o = bundle.getString("Description");

            TextView text1 = (TextView) view.findViewById(R.id.textViewds2);
            TextView text3 = (TextView) view.findViewById(R.id.textViewds1);
            TextView text4 = (TextView) view.findViewById(R.id.textViewds3);
            ImageView image = (ImageView) view.findViewById(R.id.detailcustomimageView);

            text1.setText(m.toString());
            text3.setText(q);
            text4.setText(o);
            Picasso.get()
                    .load(n)
                    .placeholder(R.drawable.ic_launcher)
                    .into( image);


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

            addtocart = view.findViewById(R.id.buttonaddtocart);

          addtocart.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

              }
          });


        }catch(Exception e){
        e.printStackTrace();}
        return view;

        }}
