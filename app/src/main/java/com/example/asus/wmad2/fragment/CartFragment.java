package com.example.asus.wmad2.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.CartAdapter;
import com.example.asus.wmad2.activities.NavigationActivity;
import com.example.asus.wmad2.models.OrderItems;
import com.example.asus.wmad2.models.Orders;
import com.example.asus.wmad2.models.Product;
import com.example.asus.wmad2.models.User;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    Button removeall;
    Button checkout;

    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     //   ((NavigationActivity)getActivity()).setActionBarTitle("Cart");

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);

        SharedPreferences preferences= getContext().getSharedPreferences("User Details", Context.MODE_PRIVATE);
        final String id = preferences.getString("id","");
        final List<Product> productList = Product.listAll(Product.class);
        try{
        final List<Orders> OrderItem = Orders.find(Orders.class,"user = ? and status = ?",id,"cart");
        final List<Orders> orders = Orders.listAll(Orders.class);
        final ListView lv = view.findViewById(R.id.listview);

        final Button removeall= view.findViewById(R.id.btnRemoveall);
        final Button checkout = view.findViewById(R.id.buttonCheckout);

        final OrderItems oi = new OrderItems();
        final User user = User.findById(User.class,Long.parseLong(id));

            removeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(Orders o:OrderItem ){
                    o.delete();;
                }
                Toast.makeText(getActivity(),"deleted all products successfully",Toast.LENGTH_LONG).show();

            }
        });

            checkout.setOnClickListener(new View.OnClickListener() {
            final List<Orders> OrderItem = Orders.find(Orders.class,"user=?",id);
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

              //  android.support.v4.app.FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fMain,new PurchaseFragment());
                fragmentTransaction.commit();




               /* for (Orders o:OrderItem){

                    oi.setOrders(o);
                    oi.setUser(user);
                    o.delete();
                }

                oi.save();

             Toast.makeText(getActivity(),"Products  purchased successfully",Toast.LENGTH_LONG).show();
             */

            }
        });
                CartAdapter ia = new CartAdapter(getActivity(),OrderItem);
                lv.setAdapter(ia);
               // final GridView MensGrid = view.findViewById(R.id.gridview);

                //lv.setAdapter(ia);
            } catch (Exception e) {
                e.printStackTrace();
        }

        return view;

    }

}
