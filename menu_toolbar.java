package com.example.myhomes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class menu_toolbar extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private static String TAG ="menu_toolbar";
    private float[] yData= {25,45.7f,45,56,67};
    private String[] xData = {"Shakir","Ali","Rana","Talha","Akbar"};
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_toolbar);
        drawerLayout=findViewById(R.id.my_drawer_layout);
        Log.d(TAG,"onCreate:starting to Create Chart");

        pieChart = (PieChart) findViewById(R.id.PieChart);
        pieChart.setContentDescription("Sales by employee()In Thousand Rs");
        pieChart.setRotationEnabled(true);
        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setCenterText("Super Cool Chart");
        pieChart.setHoleRadius(100f);
        pieChart.setTransparentCircleAlpha(2);
        pieChart.setCenterTextSize(10);
        pieChart.setDrawEntryLabels(true);



         addDataSet(pieChart);
         pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
             @Override
             public void onValueSelected(Entry e, Highlight h) {
                 Log.d(TAG, "onValueSelected: value select from chart");
                 Log.d(TAG, "onValueSelected: "+e.toString());
                 Log.d(TAG, "onValueSelected: "+h.toString());
             }

             @Override
             public void onNothingSelected() {

             }
         });

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void addDataSet(PieChart pieChart) {
        Log.d(TAG, "addDataSet: Started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();
        for (int i = 0; i < xData.length; i++) {
            xEntrys.add(xData[i]);
        }
        for (int i = 1; i < xData.length; i++) {
            xEntrys.add(xData[i]);
        }
        //create the data set//
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Employee Sales");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //Add colors to dataset

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        //ADD LEGEND TO CHART
        Legend legend = pieChart.getLegend();
        legend.setDirection(Legend.LegendDirection.RIGHT_TO_LEFT);
        legend.setForm(Legend.LegendForm.CIRCLE);
       // Create PieChart Object
        PieData pieData = new PieData();
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if (actionBarDrawerToggle.onOptionsItemSelected(item)){
           return true;
       }
        return super.onOptionsItemSelected(item);
    }
}