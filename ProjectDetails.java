package com.example.myhomes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectDetails extends AppCompatActivity {
    ImageView imageView, Architecture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);
        imageView=findViewById(R.id.RealEstate);
        Architecture = findViewById(R.id.Architecture);





        Architecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectDetails.this, com.example.myhomes.Architecture.class);
                startActivity(intent);
            }
        });



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectDetails.this,Projects.class);
                startActivity(intent);
            }
        });
    }
}