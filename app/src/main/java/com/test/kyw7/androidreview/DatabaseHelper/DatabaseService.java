package com.test.kyw7.androidreview.DatabaseHelper;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DatabaseService extends Service {
    private Timer timer = new Timer();
    private DataBaseHelper dbhelper;
    public DatabaseService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(() -> Toast.makeText(DatabaseService.this.getApplicationContext(),
                "关闭服务",
                Toast.LENGTH_SHORT).show());
        super.onDestroy();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        dbhelper = new DataBaseHelper(this,"LOG.db",null,1);
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        Handler handler = new Handler(Looper.getMainLooper());
        timer.schedule(new TimerTask() {
            @SuppressLint("DefaultLocale")
            @Override
            public void run() {
                long time = new Date().getTime();
                String log = "日志" + DateFormat.getTimeInstance().format(new Date());
                database.execSQL(String.format("insert into Log (createTime,log) values ('%d', '%s')", time, log));
                handler.post(()->{
                    Toast.makeText(DatabaseService.this.getApplicationContext(),
                            "插入" + log, Toast.LENGTH_SHORT).show();
                });
            }
        },0,30000);
        return super.onStartCommand(intent,flags,startId);
    }


}
