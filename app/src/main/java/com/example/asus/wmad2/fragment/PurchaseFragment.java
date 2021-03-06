package com.example.asus.wmad2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.NavigationActivity;
import com.example.asus.wmad2.models.OrderItems;
import com.example.asus.wmad2.models.Orders;
import com.example.asus.wmad2.models.Product;
import com.example.asus.wmad2.models.User;
import com.orm.SugarRecord;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PurchaseFragment extends Fragment {

    Product p;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Button buy;
        Button cancel;

        LayoutInflater l = LayoutInflater.from(getContext());
        ((NavigationActivity)getActivity()).setActionBarTitle("Checkout");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_purchase, container, false);

        buy = view.findViewById(R.id.btnBuy);
        cancel = view.findViewById(R.id.button3);
         // TextView ttl = view.findViewById(R.id.textViewfito);


            Bundle bundle=getArguments();
            double x=bundle.getDouble("total");
            String a=String.valueOf(x);

       // ttl.setText(a);


        final SharedPreferences preferences = getContext().getSharedPreferences("User Details", Context.MODE_PRIVATE);
        final String id = preferences.getString("id", "");


        final OrderItems oi = new OrderItems();
        final User user = User.findById(User.class, Long.parseLong(id));
        final Product product = Product.findById(Product.class, Long.parseLong(id));

       // ttl.setText(String.valueOf(ttl));


        buy.setOnClickListener(new View.OnClickListener() {
            final List<Orders> OrderItem = Orders.find(Orders.class, "user=?", id);

            @Override
            public void onClick(View v) {

                    for (Orders o : OrderItem) {

                       // product.setQuantity(o.getProduct().getQuantity()-);

                   // Date d = Calendar.getInstance().getTime();
                   // oi.setDate(d.toString());
                    oi.setOrders(o);
                    oi.setUser(user);
                    o.setStatus("purchased");
                   // o.setProduct(o.getProduct());
                    o.save();
                    oi.save();
                }
                oi.save();

                Toast.makeText(getActivity(), "Products  purchased successfully", Toast.LENGTH_LONG).show();

            }


        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //  android.support.v4.app.FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fMain,new Shop());
                fragmentTransaction.commit();


            }
        });

        return view;

    }
    }

