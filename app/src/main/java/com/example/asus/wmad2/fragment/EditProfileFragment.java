package com.example.asus.wmad2.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.NavigationActivity;
import com.example.asus.wmad2.models.User;
import com.orm.SugarRecord;

import java.util.List;


public class EditProfileFragment extends Fragment{
    EditText name, phone, email,currentpwd, newpwd, confirmpwd;
    Button update1,update2;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((NavigationActivity)getActivity()).setActionBarTitle("Edit profile");


        LayoutInflater l = LayoutInflater.from(getContext());
        View view =l.inflate(R.layout.activity_edit_profile,container,false);
        name =(EditText)view.findViewById(R.id.editTextun);
        phone=(EditText)view.findViewById(R.id.editTextup);
        email =(EditText)view.findViewById(R.id.editTexteu);
        currentpwd=(EditText)view.findViewById(R.id.editTextucp);
        newpwd=(EditText)view.findViewById(R.id.editTextunp) ;
        confirmpwd=(EditText)view.findViewById(R.id.editTextuvnp) ;
        update1=(Button)view.findViewById(R.id.buttonUpdate1);
        update2=(Button)view.findViewById(R.id.buttonUpdate2);

        update2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=currentpwd.getText().toString();
                String p=newpwd.getText().toString();
                String e=confirmpwd.getText().toString();

                pass(n,p,e);
            }
        });
        update1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String p=phone.getText().toString();
                String e=email.getText().toString();



        ud(n,p,e);
            }
        });
        return view;
    }
    public void ud(String name, String phone,String email){
        SharedPreferences preferences= this.getActivity().getApplication().getSharedPreferences("User Details",Context.MODE_PRIVATE);
      String id = preferences.getString("User ID","");
        List<User> us = User.listAll(User.class);
        User u = SugarRecord.findById(User.class,preferences.getLong("id",10));

        u.setName(name);
        u.setContactNo(phone);
        u.setEmail(email);
        u.save();
        List<User> uk = User.listAll(User.class);

    }
    public void pass(String currentpw, String newpw,String confirmpw){

        if(newpw.equals(confirmpw)){

            SharedPreferences preferences= this.getActivity().getApplication().getSharedPreferences("User Details",Context.MODE_PRIVATE);
            //  String id = preferences.getString("User ID","");
            List<User> us = User.listAll(User.class);
            User u = SugarRecord.findById(User.class,preferences.getLong("id",10));

            u.setPassword(newpw);
            u.save();
            List<User> uk = User.listAll(User.class);

        }


    }



}
