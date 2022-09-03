package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.assignment.model.Application;
import com.example.assignment.model.DatabaseHandler;

public class AllocateHousing extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    EditText fromdateEditText;
    Application application;
    String duration = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocate_housing);

        databaseHandler = new DatabaseHandler(AllocateHousing.this);
        fromdateEditText = findViewById(R.id.fromdateEditText);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);

        if (id != -1) {
            application = databaseHandler.GetApplication(id);
        }
    }

    public void CancelBtn(View view) {
        finish();
    }

    public void ApproveBtn(View view) {
        Toast.makeText(this,"Application Approved",Toast.LENGTH_SHORT).show();
        application.setFromdate(fromdateEditText.getText().toString().trim());
        application.setStatus("Approved");
        application.setDuration(duration);

        databaseHandler.AllocateHousing(application);

        finish();
        databaseHandler.close();
    }

    public void RejectBtn(View view) {
        Toast.makeText(this,"Application Rejected",Toast.LENGTH_SHORT).show();
        application.setStatus("Reject");

        databaseHandler.AllocateHousing(application);

        finish();
        databaseHandler.close();
    }

    public void WaitListBtn(View view) {
        Toast.makeText(this,"Application on Waitlist",Toast.LENGTH_SHORT).show();
        application.setStatus("Waitlist");

        databaseHandler.AllocateHousing(application);

        finish();
        databaseHandler.close();
    }

    public void RadioButtonClicked(View view) {

        //This variable will store whether the user was male or female
        // Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rd12Months:
                if (checked)
                    duration = "12 Months";
                break;
            case R.id.rd18Months:
                if (checked)
                    duration = "18 Months";
                break;
        }
    }
}