package com.example.myhomes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerDashboard extends AppCompatActivity {
ImageView imageView;
ImageView imageView1;
ImageView imageView2;
ImageView imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dashboard);

        imageView=findViewById(R.id.product);
        imageView1=findViewById(R.id.myleads);
        imageView2=findViewById(R.id.newQuery);
        imageView3=findViewById(R.id.NewsFlash);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerDashboard.this,ProjectDetails.class);
                startActivity(intent);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerDashboard.this,MyLeads.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerDashboard.this,NewQuery.class);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerDashboard.this,news_slash.class);
                startActivity(intent);
            }
        });


    }

    }