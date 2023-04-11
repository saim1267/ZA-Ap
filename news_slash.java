package com.example.myhomes;

import static com.example.myhomes.model.Constant.TOPIC;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myhomes.api.ApiUtilities;
import com.example.myhomes.databinding.ActivityNewsSlashBinding;
import com.example.myhomes.model.NotificationData;
import com.example.myhomes.model.PushNotification;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class news_slash extends AppCompatActivity {
    private static final String CHANNEL_ID="News Slash";
    private static final int NOTIFICATION_ID=100;

    ActivityNewsSlashBinding binding;
     String newsUpdate,broadCast,description;
     private EditText newsupdate,broadcast,message;
    FirebaseDatabase db;
    DatabaseReference reference;
    private final int GALLERY_REQ_CODE=1000;
   ImageView imageView;
  Button button;
  Button button1;

    public news_slash() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsSlashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        imageView=findViewById(R.id.imgGallery);
        newsupdate =findViewById(R.id.newsupdate);
        broadcast =findViewById(R.id.broadcast);
        message = findViewById(R.id.description);
        button=findViewById(R.id.btnGallery);
        button1=findViewById(R.id.btnSave);

        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsUpdate=binding.newsupdate.getText().toString();
                broadCast=binding.broadcast.getText().toString();
                description=binding.description.getText().toString();
                if(!newsUpdate.isEmpty()&& !broadCast.isEmpty()&& !description.isEmpty()){
                    PushNotification notification= new PushNotification(new NotificationData(newsUpdate,broadCast,description),TOPIC);
                    newsFlash newsFlash= new newsFlash(newsUpdate,broadCast,description);
                    db= FirebaseDatabase.getInstance();
                    reference=db.getReference("newsFlash");
                    reference.child(newsUpdate).setValue(newsFlash).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                        binding.newsupdate.setText("");
                        binding.broadcast.setText("");
                        binding.description.setText("");
                            Toast.makeText(news_slash.this, "successfully Submitted", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery =new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (requestCode==GALLERY_REQ_CODE){
                //for gallery
                imageView.setImageURI(data.getData());

            }
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tex = newsupdate.getText().toString();
                String tex1 = broadcast.getText().toString();
                String text2= message.getText().toString();


                if (!tex.isEmpty()&& !tex1.isEmpty()&& !text2.isEmpty()){
                    PushNotification notification = new PushNotification(new NotificationData(tex,tex1,text2),TOPIC);
                    sendNotification(notification);
                }
            }

            private void sendNotification(PushNotification notification) {
                ApiUtilities.getClient().sendNotification(notification).enqueue(new Callback<PushNotification>() {
                    @Override
                    public void onResponse(Call<PushNotification> call, Response<PushNotification> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(news_slash.this, "Success", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(news_slash.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<PushNotification> call, Throwable t) {
                        Toast.makeText(news_slash.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}