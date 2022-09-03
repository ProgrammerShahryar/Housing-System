package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.model.DatabaseHandler;
import com.example.assignment.model.User;

public class SignUp extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText fullnameEditText;
    EditText emailEditText;
    EditText monthEditText;


    public void signupImageButton(View view){

        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String fullname = fullnameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String monthlyincome = monthEditText.getText().toString().trim();

        User newuser = new User(null, username, password, fullname, email, monthlyincome);

        databaseHandler.AddUser(newuser);

        databaseHandler.close();
        Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);
        finish();
    }

    public void Login(View view){
        Intent intent = new Intent(SignUp.this, Login.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        databaseHandler = new DatabaseHandler(SignUp.this);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        fullnameEditText = findViewById(R.id.fullnameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        monthEditText = findViewById(R.id.monthEditText);
    }
}
