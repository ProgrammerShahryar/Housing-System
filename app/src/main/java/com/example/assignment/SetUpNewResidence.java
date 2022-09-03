package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assignment.model.DatabaseHandler;
import com.example.assignment.model.Residence;

import java.util.List;

public class SetUpNewResidence extends AppCompatActivity {
    ListView allResidencesListView;
    DatabaseHandler databaseHandler;
    Residence residence;
    ArrayAdapter adapter;

    public void UpdateBtn(View view){
        if(residence != null){
            Intent intent = new Intent(this, UpdateResidence.class);
            intent.putExtra("id",residence.getResidenceid());
            startActivity(intent);
        }
    }
    public void DeleteResidenceBtn(View view){
        if(residence != null){
            databaseHandler.DeleteResidence(residence);
            GetAllResidences();
        }
    }
    public void Home12(View view) {
        Toast.makeText(this,"Enter the Menu Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SetUpNewResidence.this, MenuHO.class);
        startActivity(intent);
    }
    public void AddResidenceBtn(View view){
        Intent intent = new Intent(this, AddResidence.class);
        startActivity(intent);
    }
    @Override
    protected void onResume(){
        super.onResume();;

        GetAllResidences();
    }

    public void GetAllResidences(){
        residence = null;
        List<Residence> residenceList = databaseHandler.GetAllResidences();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.
                simple_list_item_1, residenceList);
        allResidencesListView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_new_residence);

        databaseHandler = new DatabaseHandler(SetUpNewResidence.this);
        allResidencesListView = findViewById(R.id.allResidencesListView);

        allResidencesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                residence = (Residence) allResidencesListView.getItemAtPosition(position);
                for(int i = 0; i < allResidencesListView.getChildCount(); i++)
                    if(position == i){
                        allResidencesListView.getChildAt(i).setBackgroundColor(Color.YELLOW);
                    }
                    else{
                        allResidencesListView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
            }
        });
        GetAllResidences();
    }
}

