package com.example.todo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class MyAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder  builder = new NotificationCompat.Builder(context, "notifyLemubit")
                .setSmallIcon(R.drawable.ic_done_black_24dp)
                .setContentText("Remainder from ToDo")
                //title of the alarm will be title of the item itself,
                // which we receive  through the intent alarm_intent in "Editor.java"
                .setContentTitle(intent.getExtras().getString("title"))
                .setPriority(NotificationCompat.PRIORITY_HIGH);



        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        Log.i("INFO", "NOTIFICATION OCCURS");

        //id will be same as item_id,
        notificationManager.notify(intent.getExtras().getInt("Id"), builder.build());
    }
}