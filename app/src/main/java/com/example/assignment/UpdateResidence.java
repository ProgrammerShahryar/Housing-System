package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.assignment.model.DatabaseHandler;
import com.example.assignment.model.Residence;

public class UpdateResidence extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    EditText addressEditText;
    EditText numOfUnitEditText;
    EditText sizePerUnitEditText;
    EditText monthlyRentalEditText;
    Residence residence;

    public void UpdateResidenceBtn(View view){
        residence.setAddress(addressEditText.getText().toString().trim());
        residence.setNumOfUnit(numOfUnitEditText.getText().toString().trim());
        residence.setSizePerUnit(sizePerUnitEditText.getText().toString().trim());
        residence.setMonthlyRental(monthlyRentalEditText.getText().toString().trim());
        databaseHandler.UpdateResidence(residence);
        finish();
    }
    public void CancelBtn(View view){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_residence);

        databaseHandler = new DatabaseHandler(UpdateResidence.this);

        addressEditText = findViewById(R.id.addressEditText);
        numOfUnitEditText = findViewById(R.id.numOfUnitEditText);
        sizePerUnitEditText = findViewById(R.id.sizePerUnitEditText);
        monthlyRentalEditText = findViewById(R.id.monthlyRentalEditText);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);

        if(id != -1){
            residence = databaseHandler.GetResidence(id);
            addressEditText.setText(residence.getAddress());
            numOfUnitEditText.setText(residence.getNumOfUnit());
            sizePerUnitEditText.setText(residence.getSizePerUnit());
            monthlyRentalEditText.setText(residence.getMonthlyRental());
        }
    }
}
