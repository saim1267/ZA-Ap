package com.example.myhomes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Projects<imageView1> extends AppCompatActivity {
ImageView imageView;
ImageView imageView1;
ImageView imageView2;
ImageView imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        imageView=findViewById(R.id.myHome);
        imageView1=findViewById(R.id.Tasneem);
        imageView2=findViewById(R.id.Citi_housing);
        imageView3=findViewById(R.id.dha_inventory);




        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Projects.this,TasneemHouse.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Projects.this,MainActivity.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Projects.this,Dha_inventory.class);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Projects.this,CityHousing_inventory.class);
                startActivity(intent);
            }
        });
    }
}