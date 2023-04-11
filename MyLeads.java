package com.example.myhomes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myhomes.databinding.ActivityMyLeadsBinding;
import com.example.myhomes.model.myleads;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyLeads extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   private  static final String CHANNEL_ID= "My Leads";

   ActivityMyLeadsBinding binding;
   String leadowner,firstname,lastname,leadsource,mobile,address,category,description;


    Button btnSave;
   FirebaseDatabase db;
   DatabaseReference reference;

    private Spinner spinner;
  Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMyLeadsBinding.inflate(getLayoutInflater());
        reference = FirebaseDatabase.getInstance().getReference("Users");
        setContentView(binding.getRoot());
        spinner=findViewById(R.id.spinner);
        btnSave=findViewById(R.id.btnSave);
        btn=findViewById(R.id.selectpdf);

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leadowner=binding.leadowner.getText().toString();
                firstname =binding.firstname.getText().toString();
                lastname=binding.lastname.getText().toString();
                leadsource=binding.leadsource.getText().toString();
                mobile=binding.mobile.getText().toString();
                address=binding.address.getText().toString();
                category=binding.Purpose.getText().toString();
                description=binding.description.getText().toString();
                if (!firstname.isEmpty()&&!lastname.isEmpty()&&!leadowner.isEmpty()&&!leadsource.isEmpty()&&!mobile.isEmpty()&&!category.isEmpty()&&!description.isEmpty()){
                    myleads myleads = new myleads(leadowner,firstname,lastname,leadsource,mobile,address,category,description);
                    db = FirebaseDatabase.getInstance();
                    reference=db.getReference("myleads");
                   reference.child(leadowner).child("leadOwner").child(leadowner).child(leadsource).setValue(myleads).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.firstname.setText("");
                            binding.lastname.setText("");
                            binding.description.setText("");
                            binding.mobile.setText("");
                            binding.address.setText("");
                            binding.Purpose.setText("");
                            Toast.makeText(MyLeads.this,leadowner+ "Added", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                }

        });

















        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UploadPDF.class);
                startActivity(intent);
            }
        });

        String [] textSizes = getResources().getStringArray(R.array.font_sizes);
        String[] text = getResources().getStringArray(R.array.text_Sizes);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,textSizes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
if (adapterView.getId() ==R.id.spinner){
    String valueFromSpinner = adapterView.getItemAtPosition(position).toString();
}
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
