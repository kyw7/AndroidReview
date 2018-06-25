package com.test.kyw7.androidreview.Broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.test.kyw7.androidreview.R;

public class BroadCastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        Button button = findViewById(R.id.sendBroadCast);
        button.setOnClickListener((v)->{
            Intent intent= new Intent("com.test.kyw7.androidreview.sendBroadCast");
            intent.putExtra("number",100);
            sendBroadcast(intent);
        });
    }
}
