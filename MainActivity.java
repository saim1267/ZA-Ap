package com.example.myhomes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.myhomes.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
  ViewFlipper flipper;
  ImageView ExecutiveVillas,RoyalVillas;
  private  Button button;
  BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExecutiveVillas=findViewById(R.id.ExecutiveVillas);
        RoyalVillas= findViewById(R.id.RoyalVillas);
        button = findViewById(R.id.button);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Home);

        int imgarray[]={R.drawable.home1,R.drawable.home3,R.drawable.home4,R.drawable.home5,R.drawable.home6,R.drawable.home7,R.drawable.home8,R.drawable.home9,R.drawable.home10,R.drawable.home11};
        flipper=(ViewFlipper) findViewById(R.id.flipper);
        for(int i=0;i<imgarray.length;i++)
            showimage(imgarray[i]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,button.class);
                startActivity(intent);
            }
        });

        ExecutiveVillas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent =new Intent(MainActivity.this,ExecutiveVillas.class);
            startActivity(intent);
            }
        });

        RoyalVillas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,RoyallVillas.class);
                startActivity(intent);
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item. getItemId()){
                    case R.id.nav_profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.nav_notification:
                        startActivity(new Intent(getApplicationContext(),Notification.class));
                        overridePendingTransition(0,0);
                }
                return false;
            }
        });

    }
    public void showimage(int img){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);


        flipper.addView(imageView);
        flipper.setFlipInterval(4500);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}