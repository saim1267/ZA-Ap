package com.example.myhomes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class IntroPage extends AppCompatActivity {
ImageView imageView,imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);
        imageView=findViewById(R.id.myHomes);
        imageView1=findViewById(R.id.PlotsInventory);
        imageView2=findViewById(R.id.Services);




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IntroPage.this,Projects.class);
                startActivity(intent);
            }
        });
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(IntroPage.this,PlotsInventory.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(IntroPage.this,OurServices.class);
                startActivity(intent);
            }
        });
    }
}