package com.example.asus.wmad2.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.CartAdapter;
import com.example.asus.wmad2.activities.NavigationActivity;
import com.example.asus.wmad2.models.Orders;
import com.example.asus.wmad2.models.Product;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     //   ((NavigationActivity)getActivity()).setActionBarTitle("Cart");

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        SharedPreferences preferences= getActivity().getSharedPreferences("User Details", Context.MODE_PRIVATE);
        String id = preferences.getString("User ID","");
        final List<Product> productList = Product.listAll(Product.class);
        try{
        List<Orders> OrderItem = Orders.find(Orders.class,"user = ?",id);
        List<Orders> orders = Orders.listAll(Orders.class);
        ListView lv = view.findViewById(R.id.listview);


                CartAdapter ia = new CartAdapter(getContext(),OrderItem);
                lv.setAdapter(ia);
               // final GridView MensGrid = view.findViewById(R.id.gridview);

                //lv.setAdapter(ia);
            } catch (Exception e) {
                e.printStackTrace();
        }

        return view;

    }

}
