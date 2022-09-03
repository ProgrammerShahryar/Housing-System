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
import com.example.assignment.model.Residence;

import java.util.List;

public class ViewApplications extends AppCompatActivity {
    ListView viewApplicationListView;
    DatabaseHandler databaseHandler;
    Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_applications);

        databaseHandler = new DatabaseHandler(ViewApplications.this);
        viewApplicationListView = findViewById(R.id.viewApplicationListView);

        viewApplicationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                application = (Application) viewApplicationListView.getItemAtPosition(position);
                for(int i = 0; i < viewApplicationListView.getChildCount(); i++)
                    if(position == i){
                        viewApplicationListView.getChildAt(i).setBackgroundColor(Color.YELLOW);
                    }
                    else{
                        viewApplicationListView.getChildAt(i).setBackgroundColor(Color.TRANSPARENT);
                    }
            }
        });
        GetAllApplications();
    }

    public void Home(View view) {
        Toast.makeText(this,"Enter the Menu Page",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(ViewApplications.this, Menu.class);
        startActivity(intent);
    }

    public void Withdraw(View view) {
        if(application != null){
            databaseHandler.WithdrawApplication(application);
            GetAllApplications();
        }
    }

    public void GetAllApplications(){
        application = null;
        List<Application> applicationList = databaseHandler.GetAllApplications();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.
                simple_list_item_1, applicationList);
        viewApplicationListView.setAdapter(adapter);
    }
}
