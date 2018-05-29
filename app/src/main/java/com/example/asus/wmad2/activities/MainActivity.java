package com.example.asus.wmad2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.wmad2.R;
import com.example.asus.wmad2.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String USERNAME_KEY = "com.example.asus.wmad2,USERNAME_KEY";
    public static final String PASSWORD_KEY = "com.example.asus.wmad2,PASSWORD_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
    }

public void login(View view){

    EditText editTextUsername = findViewById(R.id.editTextUsername);
    String email = editTextUsername.getText().toString();

    EditText editText2Password = findViewById(R.id.editText2Password);
    String password = editText2Password.getText().toString();

    validate(email, password);
}
public void register(View view){

    Intent intent = new Intent(this,RegisterActivity.class);
    startActivity(intent);
}

    public void forgetpw(View view){

        Intent intent = new Intent(this,ForgetpwdActivity.class);
        startActivity(intent);
    }
    //comment
public void validate(String email, String password){
    List<User> userList = User.find(User.class, "email = ? and password = ?", email,password);
    for (User uss:userList
         ) {
        if(userList.size() == 1){
            String m = uss.getId().toString();
            Long lon=uss.getId();
            SharedPreferences preferences = getApplication().getSharedPreferences("User Details",MODE_PRIVATE);
            SharedPreferences.Editor edit =preferences.edit();
            edit.putString("id", String.valueOf(lon));
            edit.commit();


            Intent intent = new Intent(this,NavigationActivity.class);
            intent.putExtra(USERNAME_KEY , email);
            intent.putExtra( PASSWORD_KEY , password);

            startActivity(intent);
            this.finish();
        }
        else if(email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Enter Email && Password", Toast.LENGTH_LONG).show();
        }else if(email.isEmpty()) {
            Toast.makeText(this, "Enter the Email", Toast.LENGTH_LONG).show();
        }else if(password.isEmpty()){
            Toast.makeText(this, "Enter the Password", Toast.LENGTH_LONG).show();
        }
    }

    }

}



