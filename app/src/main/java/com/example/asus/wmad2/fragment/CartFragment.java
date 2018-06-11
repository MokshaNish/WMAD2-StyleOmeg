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
import android.widget.TextView;
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

    Button remall;
    Button checkout;


    public CartFragment() {
        // Required empty public constructor
    }
double total = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


      ((NavigationActivity)getActivity()).setActionBarTitle("Cart");

        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_cart, container, false);
//to get the id of the user who has logged in
        SharedPreferences preferences= getContext().getSharedPreferences("User Details", Context.MODE_PRIVATE);
        final String id = preferences.getString("id","");

        final List<Product> productList = Product.listAll(Product.class);

        try{
//the name of the arraylist is orderItem.orders is the type of the array.
            //it will retrive all the values which is from the user who has logged in
        final List<Orders> OrderItem = Orders.find(Orders.class,"user = ? and status = ?",id,"Pending");
        final List<Orders> orders = Orders.listAll(Orders.class);

            // final List<OrderItems> OrderItems= OrderItems.listAll(OrderItems.class);


        final ListView lv = view.findViewById(R.id.listview);
        final Button checkout = view.findViewById(R.id.buttonCheckout);
        final Button remall = view.findViewById(R.id.btnRemoveall);
        final TextView totalp = view.findViewById(R.id.totaltextview);


        final OrderItems oi = new OrderItems();
        final User user = User.findById(User.class,Long.parseLong(id));

        remall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Orders o:OrderItem){
                    o.delete();
                }

                Toast.makeText(getActivity(),"deleted all products successfully",Toast.LENGTH_LONG).show();

            }
        });

            for (Orders o: OrderItem){
                total = total +o.getProduct().getPrice();

            }
            totalp.setText(String.valueOf(total));

            checkout.setOnClickListener(new View.OnClickListener() {
            final List<Orders> OrderItem = Orders.find(Orders.class,"user=?",id);
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PurchaseFragment pf = new PurchaseFragment();
              // android.support.v4.app.FragmentTransaction fr = getSupportFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putDouble("total",total);
                pf.setArguments(bundle);
                fragmentTransaction.replace(R.id.fMain,pf);
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




          //  String tt =totalp.getText().toString();
           // Bundle bundle = getArguments();
          //  bundle.putDouble("",total);



            CartAdapter ia = new CartAdapter(getActivity(),OrderItem);//pass the values to the cart adapter
                lv.setAdapter(ia);
               // final GridView MensGrid = view.findViewById(R.id.gridview);

                //lv.setAdapter(ia);
            } catch (Exception e) {
                e.printStackTrace();
        }

        return view;

    }

}
