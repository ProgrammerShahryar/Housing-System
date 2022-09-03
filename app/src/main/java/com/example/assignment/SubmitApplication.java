package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.model.Application;
import com.example.assignment.model.DatabaseHandler;
import com.example.assignment.model.Residence;

public class SubmitApplication extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    EditText dateEditText;
    EditText monthEditText;
    EditText yearEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_application);


        databaseHandler = new DatabaseHandler(SubmitApplication.this);

        dateEditText = findViewById(R.id.dateEditText);
        monthEditText = findViewById(R.id.monthEditText);
        yearEditText = findViewById(R.id.yearEditText);
    }

    public void submitBtn(View view){
        Intent intent = getIntent();

        Application application = new Application();
        application.setResid(intent.getIntExtra("id", -1));
        application.setDate(dateEditText.getText().toString().trim());
        application.setMonth(monthEditText.getText().toString().trim());
        application.setYear(yearEditText.getText().toString().trim());

        databaseHandler.CreateApplication(application);

        databaseHandler.close();

        Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(SubmitApplication.this, ViewResidence.class);
        startActivity(intent2);


    }
}
