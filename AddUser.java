package com.example.myhomes;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myhomes.databinding.ActivityAdminPanelBinding;

public class AddUser extends AdminPanel {

    ActivityAdminPanelBinding activityAdminPanelBinding;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAdminPanelBinding=ActivityAdminPanelBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_add_user);
    }
}