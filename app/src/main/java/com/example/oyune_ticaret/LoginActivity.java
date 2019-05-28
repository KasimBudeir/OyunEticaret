package com.example.oyune_ticaret;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText userName;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.edittext_username);
        password = findViewById(R.id.edittext_password);


        Button login = (Button) findViewById(R.id.login_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //arrylist to hold registered users
                final ArrayList<User> registeredUsers = User.getUsers();

                final User actualuser = new User();
                actualuser.setUserName(userName.getText().toString());

                actualuser.setPassword(password.getText().toString());


                if ((registeredUsers.get(1).getUserName().equals(actualuser.getUserName()))&&(registeredUsers.get(1).getPassword().equals(actualuser.getPassword()))){

                    Intent i = new Intent(LoginActivity.this, ListActivity.class);
                    startActivity(i);
                }


            }
        });


    }






}
