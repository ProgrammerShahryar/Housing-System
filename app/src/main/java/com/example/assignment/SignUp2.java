package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.model.DatabaseHandler;
import com.example.assignment.model.User;
import com.example.assignment.model.User2;

public class SignUp2 extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    EditText usernameEditText;
    EditText passwordEditText;
    EditText fullnameEditText;

    public void signUpBtn(View view){

        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String fullname = fullnameEditText.getText().toString().trim();

        User2 newuser = new User2(null, username, password, fullname);

        databaseHandler.AddUser2(newuser);

        databaseHandler.close();
        Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(SignUp2.this, Login2.class);
        startActivity(intent);
        finish();
    }

    public void LoginHO(View view){
        Intent intent = new Intent(SignUp2.this, Login2.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        databaseHandler = new DatabaseHandler(SignUp2.this);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        fullnameEditText = findViewById(R.id.fullnameEditText);
    }
}
