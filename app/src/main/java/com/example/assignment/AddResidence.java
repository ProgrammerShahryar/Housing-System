package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.assignment.model.DatabaseHandler;
import com.example.assignment.model.Residence;

public class AddResidence extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    EditText addressEditText;
    EditText numOfUnitEditText;
    EditText sizePerUnitEditText;
    EditText monthlyRentalEditText;

    public void AddResidenceBtn(View view){
        Residence residence = new Residence();
        residence.setAddress(addressEditText.getText().toString().trim());
        residence.setNumOfUnit(numOfUnitEditText.getText().toString().trim());
        residence.setSizePerUnit(sizePerUnitEditText.getText().toString().trim());
        residence.setMonthlyRental(monthlyRentalEditText.getText().toString().trim());

        databaseHandler.AddResidence(residence);

        databaseHandler.close();
        finish();
    }

    public void CancelBtn(View view){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_residence);

        databaseHandler = new DatabaseHandler(AddResidence.this);

        addressEditText=findViewById(R.id.addressEditText);
        numOfUnitEditText=findViewById(R.id.numOfUnitEditText);
        sizePerUnitEditText=findViewById(R.id.sizePerUnitEditText);
        monthlyRentalEditText=findViewById(R.id.monthlyRentalEditText);
    }
}
