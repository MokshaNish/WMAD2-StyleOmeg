package com.example.asus.wmad2.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.NavigationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {


    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((NavigationActivity)getActivity()).setActionBarTitle("Contact Us");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);


        final EditText name = (EditText) view.findViewById(R.id.contactName);
        final EditText Email = (EditText) view.findViewById(R.id.contactEmail);
        final EditText Phone = (EditText) view.findViewById(R.id.contactPhone);
        final EditText inquery = (EditText) view.findViewById(R.id.contactinquery);

        Button b = (Button) view.findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String email = Email.getText().toString();
                String phone = Phone.getText().toString();
                String Inquery = inquery.getText().toString();

                if (TextUtils.isEmpty(Name)) {
                    name.setError("Enter Your name");
                    name.requestFocus();
                    return;

                }
                if (TextUtils.isEmpty(phone)) {
                    Phone.setError("Enter the phone number");
                    Phone.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(Inquery)) {
                    inquery.setError("Enter the Message");
                    inquery.requestFocus();
                    return;
                }

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"moksha.nish@gmail.com"});
                intent.putExtra(Intent.EXTRA_TEXT,
                        "name:" + Name + '\n' + "Email:" + email + '\n' + "inquery:" + '\n' + inquery);

                Toast.makeText(getActivity(), " Message Submitted!", Toast.LENGTH_LONG).show();

            }
        });
        return view;
    }

}