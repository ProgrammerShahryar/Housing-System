package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuHO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ho);
    }

    public void setUpNewResidence(View view) {
        Toast.makeText(this,"Enter the Set Up New Residence Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MenuHO.this, SetUpNewResidence.class);
        startActivity(intent);
    }

    public void viewApplicationHO(View view) {
        Toast.makeText(this,"Enter the View Application(Housing Officer) Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MenuHO.this, ViewApplicationHO.class);
        startActivity(intent);
    }

    public void LogOut(View view) {
        Toast.makeText(this, "Log Out Successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MenuHO.this, MainActivity.class);
        startActivity(intent);
    }
}
