package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.model.DatabaseHandler;
import com.example.assignment.model.User;

public class Login extends AppCompatActivity {
    DatabaseHandler db;
    EditText usernameEditText;
    EditText passwordEditText;

    public void loginImageButton(View view){
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        String UserName=usernameEditText.getText().toString();
        String Password=passwordEditText.getText().toString();

        //Authenticate user
        User currentUser = db.Authenticate(new User(null, UserName, Password));

        //Check Authentication is successful or not
        if (currentUser != null) {
            Toast.makeText(this, "Logged In ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, Menu.class);
            startActivity(intent);
            //User Logged in Successfully Launch You home screen activity

        } else {
            Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
            //User Logged in Failed
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHandler(Login.this);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }
}
