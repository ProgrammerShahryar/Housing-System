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

public class ViewResidence extends AppCompatActivity {
    ListView viewResidencesListView;
    DatabaseHandler databaseHandler;
    Residence residence;
    ArrayAdapter adapter;


    public void GetAllResidences(){
        residence = null;
        List<Residence> residenceList = databaseHandler.GetAllResidences();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.
                simple_list_item_1, residenceList);
        viewResidencesListView.setAdapter(adapter);
    }

    public void Home2(View view) {
        Toast.makeText(this,"Enter the Menu Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ViewResidence.this, Menu.class);
        startActivity(intent);
    }

    public void composeButton(View view){
        if (residence != null) {
            Intent intent = new Intent(this, SubmitApplication.class);
            intent.putExtra("id", residence.getResidenceid());
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_residence);

        databaseHandler = new DatabaseHandler(ViewResidence.this);
        viewResidencesListView = findViewById(R.id.viewResidencesListView);

        viewResidencesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                residence = (Residence) viewResidencesListView.getItemAtPosition(position);
                for(int i = 0; i < viewResidencesListView.getChildCount(); i++)
                    if(position == i){
                        viewResidencesListView.getChildAt(i).setBackgroundColor(Color.YELLOW);
                    }
                    else{
                        viewResidencesListView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
            }
        });
        GetAllResidences();
    }
}
