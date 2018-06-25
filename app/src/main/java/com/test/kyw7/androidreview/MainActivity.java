package com.test.kyw7.androidreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.kyw7.androidreview.Broadcast.BroadCastActivity;
import com.test.kyw7.androidreview.httpService.HttpActivity;
import com.test.kyw7.androidreview.map.MapActivity;
import com.test.kyw7.androidreview.register.RegisterActivity;
import com.test.kyw7.androidreview.subject.SubjectActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final static List<String> titiles = Arrays.asList(
            "Activity跳转",
            "网络请求",
            "访问通讯录",
            "地图操作",
            "普通广播",
            "学科显示",
            "数据库插入",
            "数据库显示"
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this,R.layout.item_title,titiles));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int positon, long id) {
                Intent intent = null;
                switch (positon){
                    case 0:
                        intent = new Intent(MainActivity.this, RegisterActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, HttpActivity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, BroadCastActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, MapActivity.class);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, BroadCastActivity.class);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, SubjectActivity.class);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, BroadCastActivity.class);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this, BroadCastActivity.class);
                        break;
                        default:
                            break;
                }
                startActivity(intent);
            }
        });

    }
}
