package com.example.asus.wmad2.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.Review;

import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class ReviewAdapter extends ArrayAdapter<Review> {

    TextView msg;
    TextView date;

    public ReviewAdapter(@NonNull Context context, @NonNull List<Review> objects) {
        super(context, R.layout.customreview, objects);
    }
    @Override
    @NonNull

    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.customreview, parent, false);
        final Review r = getItem(position);
       // final Review e = new Review();


        Date d = Calendar.getInstance().getTime();
        d.toString();
        r.setDate(d.toString());

        msg = view.findViewById(R.id.textView30);
      // date  = view.findViewById(R.id.textView31);


        try {
            msg.setText(r.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    public static class ForgetPasswordActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forgetpwd);


        }
    }
}
