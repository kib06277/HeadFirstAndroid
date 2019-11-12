package com.hfad.joke;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class DelayedMessageService extends IntentService
{
    private Handler handler;

    public static final String EXTRA_MESSAGE = "message";

    // Used in Toast version 訊息版本
    public static final int NOTIFICATION_ID = 5453;

    public DelayedMessageService()
    {
        super("DelayedMessageService");
    }

    // Used in Toast version 使用訊息的版本
    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId)
    {
        handler = new Handler();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        synchronized (this)
        {
            try
            {
                wait(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);
    }

    private void showText(final String text)
    {
         Log.v("DelayedMessageService", "The message is: " + text); // Used in log version
         handler.post(new Runnable()
         {
             //Used in Toast version
             //使用訊息版本
             @Override
             public void run()
             {
                 Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
             }
         });

        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        //使用通知
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) //展示 notification 小圖示
                .setContentTitle(getString(R.string.app_name)) //展示 notification 標題
                .setAutoCancel(true) //讓 notification 被典籍消失
                .setPriority(Notification.PRIORITY_MAX) //賦予最高優先權
                .setDefaults(Notification.DEFAULT_VIBRATE) //震動提示
                .setContentIntent(pendingIntent)
                .setContentText(text).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
