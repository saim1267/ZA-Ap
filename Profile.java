package com.example.myhomes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {
  BottomNavigationView bottomNavigationView;
  EditText mEmail,mPassword;
  Button mLoginBtn;
  TextView mCreatetext;



  FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
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
        mEmail=findViewById(R.id.email);
        mPassword=findViewById(R.id.password);
        mLoginBtn=findViewById(R.id.loginBtn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = mEmail.getText().toString();
                String item1 = mPassword.getText().toString();
                if (mEmail.getText().toString().equals("admin") && mPassword.getText().toString().equals("Admin") && item.equals("admin")) {
                    Intent intent = new Intent(Profile.this, AdminPanel.class);
                    startActivity(intent);
                } else if (mEmail.getText().toString().equals("user")&& mPassword.getText().toString().equals("user")&& item.equals("user")){

                    Intent intent = new Intent(Profile.this,CustomerDashboard.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Profile.this, "Error", Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}