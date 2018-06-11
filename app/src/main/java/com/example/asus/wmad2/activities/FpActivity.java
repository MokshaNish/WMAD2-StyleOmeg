package com.example.asus.wmad2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.User;
import com.orm.SugarRecord;

import java.util.List;
public class FpActivity extends AppCompatActivity {
    Long userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);

        LayoutInflater i=LayoutInflater.from(this);
        final EditText name = (EditText)findViewById(R.id.usernameET);
        final EditText newpwd =(EditText) findViewById(R.id.newPasswordET);
        final EditText confirmpwd = (EditText)findViewById(R.id.reenterNewPasswordET);
        Button updatef=(Button)findViewById(R.id.setAsNewPassword);
        Button returnm=(Button)findViewById(R.id.returnButton);

        updatef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = name.getText().toString();
                String b = newpwd.getText().toString();
                String c = confirmpwd.getText().toString();

                validatepass(a,b,c);
            }
        });

    }

    private void validatepass(String name, String newpwd, String confirmpwd) {
        if (newpwd.equals(confirmpwd)) {

        List<User> userlist= User.find(User.class, " name = ?", name);
        for(User u:userlist){
            if(u.getName().equals(name)){
                userid=u.getId();
            }

        }
            User a = User.findById(User.class, userid);
           // String o = preferences.getString("id", "");

//comment
            a.setPassword(newpwd);
            a.save();
            List<User> uk = User.listAll(User.class);
            Toast.makeText(this, "Password reset Successfully", Toast.LENGTH_LONG).show();

        }


    }

    public void returnm(View view) {

        Intent intent = new Intent(FpActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }}


