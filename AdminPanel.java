package com.example.myhomes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class AdminPanel extends AppCompatActivity {
public DrawerLayout drawerLayout;
    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    TextView firebasename;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        imageView= findViewById(R.id.product);
        imageView1=findViewById(R.id.NewsFlash);
        imageView2=findViewById(R.id.myleads);
        imageView3=findViewById(R.id.newQuery);
        firebasename=findViewById(R.id.firebasename);


        NavigationView navigationView = drawerLayout.findViewById(R.id.navigationview);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_account:
                        startActivity(new Intent(getApplicationContext(),MyAccount.class));
                        overridePendingTransition(0,0);
                        return true;
                            case R.id.nav_adduser:
                                startActivity(new Intent(getApplicationContext(),AddUser.class));
                                overridePendingTransition(0,0);
                                return true;
                    case R.id.nav_logout:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                    case R.id.nav_Viewleads:
                        startActivity(new Intent(getApplicationContext(),ViewInventory.class));
                }


                return false;
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        firebasename.setText("Welcome, Admin");

        
        
        
        

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanel.this,ProjectDetails.class);
                startActivity(intent);
            }
        });
imageView1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(AdminPanel.this,news_slash.class);
        startActivity(intent);
    }
});
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanel.this,MyLeads.class);
                startActivity(intent);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminPanel.this,NewQuery.class);
                startActivity(intent);
            }
        });






        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

