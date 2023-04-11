package com.example.myhomes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OurServices extends AppCompatActivity {
ImageView RealEstate,Architecture,PropertyManagement,ResidentialConstruction,CommercialConstruction,IndustrialConstruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_services);
        RealEstate=findViewById(R.id.RealEstate);
        Architecture=findViewById(R.id.Architecture);
        PropertyManagement=findViewById(R.id.PropertyManagement);
        ResidentialConstruction=findViewById(R.id.ResidentialConstruction);
        CommercialConstruction=findViewById(R.id.CommercialConstruction);
        IndustrialConstruction=findViewById(R.id.IndustrialConstruction);


        RealEstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurServices.this,RealEstate.class);
                startActivity(intent);
            }
        });
        Architecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurServices.this,Architecture.class);
                startActivity(intent);
            }
        });
        PropertyManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurServices.this,PropertyManagement.class);
                startActivity(intent);
            }
        });
        ResidentialConstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurServices.this,ResidentialConstruction.class);
                startActivity(intent);
            }
        });
       CommercialConstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurServices.this,CommercialConstruction.class);
                startActivity(intent);
            }
        });
        IndustrialConstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurServices.this,IndustrialConstruction.class);
                startActivity(intent);
            }
        });
    }
}