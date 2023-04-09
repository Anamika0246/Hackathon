package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hackathon.Adapter.Dogs_Adapter;
import com.example.hackathon.Model.Dogs;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.add_btn);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , Fill_Activity.class);
              startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recycle_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList <Dogs> list = new ArrayList<>();


        list.add(new Dogs(R.drawable.icon, "Location", "Description" ));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));
        list.add(new Dogs(R.drawable.icon, "Location", "Description"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Dogs_Adapter adapter = new Dogs_Adapter(list,this);

        recyclerView.setAdapter(adapter);


    }
}