package com.test.kyw7.androidreview.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.test.kyw7.androidreview.R;
public class OutputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Person person = getIntent().getParcelableExtra("person");
        TextView tv = findViewById(R.id.text);
        tv.setText(String.format("姓名：%s\n性别：%s\n密码：%s\n", person.getName(),
                person.getGender() == 0 ? "男" : "女",
                person.getPassword()));
    }
}
