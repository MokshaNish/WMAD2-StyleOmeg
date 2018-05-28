package com.example.asus.wmad2.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.User;
import com.orm.SugarRecord;

import java.util.HashMap;
import java.util.List;

public class ForgetpwdActivity extends AppCompatActivity {

   // EditText username, newPass, newPass2,ReturnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        TextView title = (TextView) findViewById(R.id.FPTitle);

        //Underlines the page's headline
        title.setPaintFlags(title.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        OnButtonClick();
    }

    public void OnButtonClick() {
        LayoutInflater i = LayoutInflater.from(this);
       // Button ReturnBtn = (Button) findViewById(R.id.returnButton);
        Button updateBtn = (Button) findViewById(R.id.setAsNewPassword);
       final EditText username = (EditText) findViewById(R.id.usernameET);
        final EditText newPass = (EditText) findViewById(R.id.newPasswordET);
        final EditText newPass2 = (EditText) findViewById(R.id.reenterNewPasswordET);


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //HashMap postData = new HashMap();
                String m = username.getText().toString();
                String n = newPass2.getText().toString();
                String x=newPass.getText().toString();

                //    PostResponseAsyncTask taskUpdate = new PostResponseAsyncTask(ForgetpwdActivity.this, postData, new AsyncResponse() {

                List<User> uss=User.listAll(User.class);
                for (User us:uss
                     ) {

                    if(us.getName().equals(m)){

                        us.setPassword(n);


                    }

                }


            }
            private void processFinish(String m, String n) {
                if (n.contains("Update Successful")) {


                    List<User>  us = User.listAll(User.class);
                    for (User uu:us
                         ) {if(uu.getEmail().equals(m)){

                        uu.setPassword(n);
                        uu.setEmail(m);

                        uu.save();
                    }

                    }



                    Toast.makeText(ForgetpwdActivity.this, "Update Successful", Toast.LENGTH_LONG).show();

                  //  Intent intent = new Intent(ForgetpwdActivity.this, MainActivity.class);
                  //  startActivity(intent);
                } else if (n.contains("Update Unsuccessful") || !(newPass.getText().equals(newPass2.getText().toString())) || ((newPass.getText().length() < 1) || (newPass2.getText().length() < 1))) {
                    AlertDialog.Builder dialogBox = new AlertDialog.Builder(ForgetpwdActivity.this);
                    dialogBox.setMessage("These reasons causes errors..." + "\n1. Both passwords are not identical" + "\n2. One (or both) of your passwords are not 8 characters long" + "\n3. Your username is incorrect (or doesn't exist)")
                            .setCancelable(false)
                            .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();//closes the dialog box
                                }
                            });

                    AlertDialog dialog = dialogBox.create();
                    dialog.setTitle("An Error was Detected!");
                    dialog.show();



                    // taskUpdate.execute("http://group8.hol.es/update.php/");


                    //Upon being pressed, takes the user to the login page
                  //  ReturnBtn.setOnClickListener(new View.OnClickListener() {
                     //   @Override
                      //  public void onClick(View v) {
                        //    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                     //   }
                  //  });
                }
            }
    }); }}

