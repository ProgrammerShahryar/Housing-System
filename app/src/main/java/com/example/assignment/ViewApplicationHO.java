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

import com.example.assignment.model.Application;
import com.example.assignment.model.DatabaseHandler;

import java.util.List;

public class ViewApplicationHO extends AppCompatActivity {
    ListView viewApplicationHoListView;
    DatabaseHandler databaseHandler;
    Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_application_ho);

        databaseHandler = new DatabaseHandler(ViewApplicationHO.this);
        viewApplicationHoListView = findViewById(R.id.viewApplicationHoListView);

        viewApplicationHoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                application = (Application) viewApplicationHoListView.getItemAtPosition(position);
                for(int i = 0; i < viewApplicationHoListView.getChildCount(); i++)
                    if(position == i){
                        viewApplicationHoListView.getChildAt(i).setBackgroundColor(Color.YELLOW);
                    }
                    else{
                        viewApplicationHoListView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
            }
        });
        GetAllApplications();
    }

    public void Home1(View view) {
        Toast.makeText(this,"Enter the Menu Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ViewApplicationHO.this, MenuHO.class);
        startActivity(intent);
    }

    public void AllocateBtn(View view){
        if(application != null){
            Toast.makeText(this,"Enter the Allocation Page",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AllocateHousing.class);
            intent.putExtra("id",application.getId());
            startActivity(intent);
        }
    }

    public void GetAllApplications(){
        application = null;
        List<Application> applicationList = databaseHandler.GetAllApplications();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.
                simple_list_item_1, applicationList);
        viewApplicationHoListView.setAdapter(adapter);
    }
}
