package com.example.asus.wmad2.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.NavigationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutFragment extends Fragment {


    public CheckoutFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((NavigationActivity)getActivity()).setActionBarTitle("Checkout");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false);
    }


}
