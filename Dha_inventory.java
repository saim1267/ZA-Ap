package com.example.myhomes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dha_inventory extends AppCompatActivity {
    Button button,button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dha_inventory);
        button=findViewById(R.id.Maral_5_Details);
        button1=findViewById(R.id.Marla_8_Details);
        button2=findViewById(R.id.Marla_10_Details);
        button3=findViewById(R.id.kanal_1_Details);
        button4=findViewById(R.id.kanal_2_Details);
        button5=findViewById(R.id.Marla_2_Details);
        button6=findViewById(R.id.Marla_4_Details);
//        1st Button code////
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dha_inventory.this,Marla_5_Details.class);
                startActivity(intent);
            }
        });
//        2nd Button code////
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dha_inventory.this,Marla_8_Details.class);
                startActivity(intent);
            }
        });
//        3rd button code////
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dha_inventory.this,Marla_10_Details.class);
                startActivity(intent);
            }
        });
//        4th Button Code///
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dha_inventory.this,Kanal_1_Details.class);
                startActivity(intent);
            }
        });
//        5th Button Code////
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dha_inventory.this,Kanal_2_Details.class);
                startActivity(intent);
            }
        });
//        6th button code////
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dha_inventory.this,Marla_2_Details.class);
                startActivity(intent);
            }
        });
//        7th button code///
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dha_inventory.this,Marla_4_Details.class);
                startActivity(intent);
            }
        });
    }
}