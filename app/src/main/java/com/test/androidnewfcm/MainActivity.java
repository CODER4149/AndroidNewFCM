package com.test.androidnewfcm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    Button btn_get_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get_token = findViewById(R.id.btn_get_token);

        btn_get_token.setOnClickListener((view -> {
            FirebaseMessaging.getInstance().getToken().addOnSuccessListener(new OnSuccessListener<String>() {
                @Override
                public void onSuccess(String s) {
                    Log.d(Utils.Tag,s);
                }
            }).addOnFailureListener(e ->{
                Toast.makeText(this,"Failed to get Token", Toast.LENGTH_SHORT).show();
            });
        }));


    }
}