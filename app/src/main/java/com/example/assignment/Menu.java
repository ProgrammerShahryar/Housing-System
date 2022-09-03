package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void viewApplication(View view) {
        Toast.makeText(this,"Enter the View Application(Applicant) Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Menu.this, ViewApplications.class);
        startActivity(intent);
    }

    public void viewResidence(View view) {
        Toast.makeText(this,"Enter the View Residence Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Menu.this, ViewResidence.class);
        startActivity(intent);
    }

    public void logOut(View view) {
        Toast.makeText(this, "Log Out Successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Menu.this, MainActivity.class);
        startActivity(intent);
    }

}
