package com.test.kyw7.androidreview.DatabaseHelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.kyw7.androidreview.R;
public class DatabaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        findViewById(R.id.btn_start).setOnClickListener((v) -> {
            Intent intent = new Intent(this, DatabaseService.class);
            startService(intent);
        });
        findViewById(R.id.btn_stop).setOnClickListener((v) -> {
            Intent intent = new Intent(this, DatabaseService.class);
            stopService(intent);
        });
    }
}
