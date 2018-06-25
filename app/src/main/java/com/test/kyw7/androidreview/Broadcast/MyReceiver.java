package com.test.kyw7.androidreview.Broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.test.kyw7.androidreview.R;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager =(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(context,ReceiveActivity.class);
        intent1.putExtra("number",intent.getIntExtra("number",0));
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent1,0);
        Notification notification = new NotificationCompat.Builder(context, "simple")
                .setContentText("启动B活动")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_foreground))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true).build();
        manager.notify(1,notification);
    }
}
