package com.example.actionalblenotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String action=intent.getAction();
        if(action.equals("NOTIFY_TO_RECEIVER")){

          triggerNotification();



        }
    }

    private void triggerNotification() {

        MynotificationManager mynotificationManager=MynotificationManager.getInstance();
        mynotificationManager.createNotificationChannel();
        mynotificationManager.showNotification();
    }
}