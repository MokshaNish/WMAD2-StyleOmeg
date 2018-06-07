package com.example.asus.wmad2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.CartAdapter;
import com.example.asus.wmad2.activities.HistoryAdapter;
import com.example.asus.wmad2.activities.NavigationActivity;
import com.example.asus.wmad2.models.OrderItems;
import com.example.asus.wmad2.models.Orders;
import com.example.asus.wmad2.models.Product;
import com.example.asus.wmad2.models.User;

import java.util.List;


public class HistoryFragment extends Fragment {



        //   ((NavigationActivity)getActivity()).setActionBarTitle("Cart");

        // Inflate the layout for this fragment
       // View view= inflater.inflate(R.layout.fragment_cancel_cart, container, false);
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((NavigationActivity) getActivity()).setActionBarTitle("History");
        LayoutInflater l = LayoutInflater.from(getContext());

        View view = l.inflate(R.layout.fragment_history, container, false);

        SharedPreferences preferences= getContext().getSharedPreferences("User Details", Context.MODE_PRIVATE);
        final String id = preferences.getString("id","");
        final List<Product> productList = Product.listAll(Product.class);
        try{
           // final List<Orders> OrderItem = Orders.find(Orders.class,"user = ? and status = ?",id,"cart");
             final List<OrderItems> asd= OrderItems.listAll(OrderItems.class);
           // final List<Orders> orders = Orders.listAll(Orders.class);
            final ListView lv = view.findViewById(R.id.listview1);


            HistoryAdapter ia = new HistoryAdapter(getActivity(),asd);
            lv.setAdapter(ia);
            // final GridView MensGrid = view.findViewById(R.id.gridview);

            //lv.setAdapter(ia);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;

    }

}

