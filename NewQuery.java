package com.example.myhomes;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myhomes.databinding.ActivityNewQueryBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewQuery extends AppCompatActivity {
    ActivityNewQueryBinding binding;
    String name,inquery,phone,description;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewQueryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.Name.getText().toString();
                inquery =binding.inquery.getText().toString();
                phone=binding.phone.getText().toString();
                description= binding.description.getText().toString();
                if (!name.isEmpty()&&!inquery.isEmpty()&&!phone.isEmpty()&&!description.isEmpty()){
                    Query query = new Query(name,inquery,phone,description);
                    db=FirebaseDatabase.getInstance();
                    reference=db.getReference("Query");
                    reference.child(inquery).setValue(query).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.Name.setText("");
                            binding.inquery.setText("");
                            binding.phone.setText("");
                            binding.description.setText("");
                            Toast.makeText(NewQuery.this, "Successfully Submitted Your Query", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}