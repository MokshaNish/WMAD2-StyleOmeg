package com.example.asus.wmad2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.activities.MainActivity;
import com.example.asus.wmad2.models.User;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent intent = getIntent();
    }

    public void join(View view){

        EditText editTextname = findViewById(R.id.editTextname);
        EditText editTextemail = findViewById(R.id.editTextemail);
        EditText editTextpassword = findViewById(R.id.editTextpassword);
        EditText editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        EditText editTextContactNumber = findViewById(R.id.editTextContactNumber);


        String name = editTextname.getText().toString();
        String email = editTextemail.getText().toString();
        String password = editTextpassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
         String contactNo = editTextContactNumber.getText().toString();

        validateRegister(name,email,password,confirmPassword,contactNo);




    }

    public void validateRegister(String name,String email,String password,String confirmpassword, String contactNo){

        if(name.isEmpty()||email.isEmpty()|| password.isEmpty()|| confirmpassword.isEmpty()|| contactNo.isEmpty()){

            Toast.makeText(this,"Fill the registration form " , Toast.LENGTH_SHORT).show();
        }else if (confirmpassword.equals(password)){

            String n=name;
            String e= email;
            String p =password;
            String c= confirmpassword;
            String o= contactNo;



            User user = new User(e,p,n,o);
           user.save();

            Intent intent = new Intent( RegisterActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            Toast.makeText(this,"User registered successfully" , Toast.LENGTH_SHORT).show();



        }else{
            Toast.makeText(this,"Wrong password", Toast.LENGTH_SHORT).show();

        }
    }
}
