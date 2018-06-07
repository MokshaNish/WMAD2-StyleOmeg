package com.example.asus.wmad2.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.example.asus.wmad2.activities.NavigationActivity;
import com.example.asus.wmad2.activities.favAdapter;
import com.example.asus.wmad2.models.Favorite;
import com.example.asus.wmad2.models.OrderItems;
import com.example.asus.wmad2.models.Orders;
import com.example.asus.wmad2.models.Product;
import com.example.asus.wmad2.models.User;

import java.util.List;


public class FavFragment extends android.support.v4.app.Fragment {

    public FavFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         ((NavigationActivity)getActivity()).setActionBarTitle("Favorite");

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fav, container, false);

        SharedPreferences preferences= getActivity().getSharedPreferences("User Details", Context.MODE_PRIVATE);
        final String id = preferences.getString("id","");
        final List<Product> productList = Product.listAll(Product.class);
        try{
            final List<Favorite> favorite = Favorite.find(Favorite.class,"user = ?",id);
            // final List<OrderItems> OrderItems= OrderItems.listAll(OrderItems.class);
          //  final List<Favorite> favorite = Favorite.listAll(Favorite.class);
            ListView lx = view.findViewById(R.id.listviewfav);




            final OrderItems oi = new OrderItems();
            final User user = User.findById(User.class,Long.parseLong(id));



           favAdapter fa = new favAdapter(getActivity(),favorite);
           lx.setAdapter(fa);

            // final GridView MensGrid = view.findViewById(R.id.gridview);

            //lv.setAdapter(ia);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;

    }

}


