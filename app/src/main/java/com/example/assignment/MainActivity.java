package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void applicant(View view){
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);

    }

    public void user2(View view){
        Intent intent = new Intent(MainActivity.this, SignUp2.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
