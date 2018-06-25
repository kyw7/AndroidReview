package com.test.kyw7.androidreview.Broadcast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.test.kyw7.androidreview.R;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        TextView textView = findViewById(R.id.textview);
        int number = getIntent().getIntExtra("number",0);
        textView.setText(String.valueOf(number));
    }
}
