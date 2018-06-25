package com.test.kyw7.androidreview.log;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.kyw7.androidreview.DatabaseHelper.DataBaseHelper;
import com.test.kyw7.androidreview.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.PrimitiveIterator;

public class LogActivity extends AppCompatActivity {

    private ArrayAdapter<log> adapter;
    private List<log> logs;
    private DataBaseHelper dataBaseHelper;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ListView listView = findViewById(R.id.logListView);
        loadData();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,logs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent,view,positon,id)->{
            showDetail(logs.get(positon));
        });

    }

    private void showDetail(log log) {
        AlertDialog dialog  = new AlertDialog.Builder(this).create();
        dialog.setTitle("这是该记录的详细情况");
        dialog.setMessage("是否删除("+log.log+")");
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"取消",(AlertDialog,which)->{
            dialog.dismiss();
        });
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE,"删除",(Alertdialog,which)->{
            dataBaseHelper.getWritableDatabase().delete("LOG","id=?",new String[]{String.valueOf(log.id)});
            adapter.remove(log);
            dialog.dismiss();
        });
        dialog.show();
    }

    public void loadData(){
        logs = new ArrayList<>();
        dataBaseHelper = new DataBaseHelper(this,"LOG.db",null,1);
        SQLiteDatabase database = dataBaseHelper.getReadableDatabase();
        long day = getStartTime();
        Cursor cursor = database.query("LOG",null,"createTime>?",
                new String[]{String.valueOf(day)},null,null,"CreateTime desc");
        if (cursor.moveToNext()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                long time = cursor.getLong(cursor.getColumnIndex("createTime"));
                String log = cursor.getString(cursor.getColumnIndex("log"));
                logs.add(new log(id, time, log));
            }while (cursor.moveToNext());
        }
    }
    public long getStartTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }
}
