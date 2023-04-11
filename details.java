package com.example.myhomes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class details extends AppCompatActivity {
 Button button;
 ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        button=findViewById(R.id.button1);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(details.this, "Your Offer has been Submitted", Toast.LENGTH_SHORT).show();
           }
       });
        int imgarray[]={R.drawable.home1,R.drawable.home18,R.drawable.home3,R.drawable.home4,R.drawable.home5,R.drawable.home6,R.drawable.home8,R.drawable.home7,R.drawable.home8,R.drawable.home13};
        flipper=(ViewFlipper) findViewById(R.id.flipper);
        for(int i=0;i<imgarray.length;i++)
            showimage(imgarray[i]);
    }

    private void showimage(int img) {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);


        flipper.addView(imageView);
        flipper.setFlipInterval(4500);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this, android.R.anim.slide_in_left);
        flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}