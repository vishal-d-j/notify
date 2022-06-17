package com.example.actionalblenotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MynotificationManager {
    public static final int v4=00;
    static MynotificationManager mynotificationManager;
    public String mchannelId="Mynotification";
    NotificationManagerCompat notificationManagerCompat;
    NotificationCompat.Builder notificationCompatBuilder;
    public static final int Notification_ID=10;
    CharSequence cname="Notification";
    String mDescription="This is my notification";
    Context context;
    NotificationManager notificationManager;
    NotificationChannel notificationChannel;

    public MynotificationManager(Context context, NotificationManager notificationManager,
                                 NotificationChannel notificationChannel) {
        this.context = getInstance().context;
        this.notificationManager = notificationManager;
        this.notificationChannel = notificationChannel;
    }

    public static MynotificationManager getInstance(){
        if(mynotificationManager==null)
        {
            mynotificationManager=new MynotificationManager();
        }
        return mynotificationManager;
    }

    private MynotificationManager(){

    }

    public void createNotificationChannel(){
        mchannelId="NoticationChannel";
        CharSequence cname="Notification";
        String mDescription="This is my notification";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(mchannelId, cname, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription(mDescription);
            NotificationManager notificationManager= getInstance().context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }


    }

    public void showNotification(){
        Intent intent=new Intent(getInstance().context.getApplicationContext(),MainActivity2.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(getInstance().context.getApplicationContext(),0,intent,PendingIntent.FLAG_IMMUTABLE);

        String textTitle="Welcome";
        String textContent="This is my first notification";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getInstance().context.getApplicationContext(), mchannelId)
                .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManager notificationManager =getInstance().context.getSystemService(NotificationManager.class);
        notificationManager.notify(0, builder.build());


    }
}
