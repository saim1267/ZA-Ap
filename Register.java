//package com.example.myhomes;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.util.Patterns;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.ActionCodeSettings;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Register extends AppCompatActivity {
//    public static final String TAG ="TAG";
//  EditText mFullName,mEmail,mPassword,mPhone;
//  Button mRegister;
//  TextView mLoginBtn;
//  ProgressBar progressBar;
//
//
//  FirebaseFirestore fstore;
//  String userID;
//  FirebaseAuth fAuth;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//        mFullName=findViewById(R.id.fullname);
//        mEmail=findViewById(R.id.email);
//        mPhone=findViewById(R.id.phone);
//        mPassword=findViewById(R.id.password);
//        mRegister=findViewById(R.id.register);
//        mLoginBtn=findViewById(R.id.createtext);
//        progressBar=findViewById(R.id.progressBar);
//
//
//        fAuth=FirebaseAuth.getInstance();
//        fstore=FirebaseFirestore.getInstance();
//
//        if(fAuth.getCurrentUser()!=null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//        }
//
//
//        mLoginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),Profile.class));
//            }
//        });
//        mRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String email=mEmail.getText().toString().trim();
//                String password=mPassword.getText().toString().trim();
//                final String fullName=mFullName.getText().toString();
//                final String phone=mPhone.getText().toString();
//                if(email.isEmpty()){
//                    mEmail.setError("Email is Required");
//                    mEmail.requestFocus();
//                    return;
//                }
//                if(fullName.isEmpty()) {
//                    mFullName.setError("Its Empty");
//                    mFullName.requestFocus();
//                    return;
//                }
//
//                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                    mEmail.setError("Not a valid emailaddress");
//                    mEmail.requestFocus();
//                    return;
//                }
//                if (password.isEmpty()) {
//                    mPassword.setError("Its empty");
//                    mPassword.requestFocus();
//                    return;
//                }
//                if(password.length()< 6){
//                    mPassword.setError("Password Must be >= 6 character");
//                    mPassword.requestFocus();
//                    return;
//                }
//                if (phone.isEmpty()) {
//            mPhone.setError(getString(R.string.action_settings));
//            mPhone.requestFocus();
//            return;
//        }
//
//        if (phone.length() != 10) {
//            mPhone.setError(getString(R.string.action_settings));
//            mPhone.requestFocus();
//            return;
//        }
//                progressBar.setVisibility(View.VISIBLE);
//
//
//
//
//                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public <DocumentReference> void onComplete(@NonNull Task<AuthResult> task) {
//                        if(task.isSuccessful()){
//
//                            FirebaseUser fuser=fAuth.getCurrentUser();
//                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.d(TAG,"Onfailure:Email Not Sent" + e.getMessage());
//                                }
//                            });
//                            ActionCodeSettings actionCodeSettings =
//                                    ActionCodeSettings.newBuilder()
//                                            // URL you want to redirect back to. The domain (www.example.com) for this
//                                            // URL must be whitelisted in the Firebase Console.
//                                            .setUrl("https://www.example.com/finishSignUp?cartId=1234")
//                                            // This must be true
//                                            .setHandleCodeInApp(true)
//                                            .setIOSBundleId("com.example.ios")
//                                            .setAndroidPackageName(
//                                                    "com.example.android",
//                                                    true, /* installIfNotAvailable */
//                                                    "12"    /* minimumVersion */)
//                                            .build();
//                            Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
//                            userID=fAuth.getCurrentUser().getUid();
//                            DocumentReference documentReference=fstore.collection("user").document(userID);
//                            Map<String,Object>user=new HashMap<>();
//                            user.put("fName",fullName);
//                            user.put("email",email);
//                            user.put("phone",phone);
//                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void unused) {
//                                    Log.d(TAG,"onsucces:user profile is created for"+userID);
//
//                                }
//                            }).addOnFailureListener(new OnFailureListener() {
//                                @Override
//                                public void onFailure(@NonNull Exception e) {
//                                    Log.d(TAG,"onFailure:"+e.toString());
//                                }
//                            });
//                            startActivity(new Intent(getApplicationContext(),Register.class));
//                        }
//                        else{
//                            Toast.makeText(Register.this, "Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }
//                });
//            }
//        });
//
//
//
//    }
//}