package com.example.anurag_pc.shreyafinalproject.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.anurag_pc.shreyafinalproject.R;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Anurag-PC on 7/13/2017.
 */

public class TestService extends Service {

    public static final String TAG ="TestService";
    public static String ACTION="TestAction";
    private Timer mTimer;
    private int notifyId= 100;
    public static final String UPDATE ="update";
    private int update =0;
    private NotificationManager manager;
    private int flags;
    private Notification.Style bigPictureStyle;
    //private TimerTask timerTask;


    @Override
    public void onCreate() {
        super.onCreate();
        mTimer= new Timer();
        mTimer.schedule(timerTask,2000,2 * 1000);
        //notification();
        Toast.makeText(this, "Hello I am in onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //super.onDestroy();
//        String value = intent.getStringExtra("Service");
//        //mTimer.schedule(new UpdateTask(),0,2000);
//        notification();
//        Toast.makeText(this, "Hello I am in onStart", Toast.LENGTH_SHORT).show();
//        Log.d(TAG,"Service started and running");
        try{

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Log.e("Log","running");
            notification();
        }
    };

    public void notification() {

        IntentFilter intentFilter= new IntentFilter();
        intentFilter.addAction("RSSPullService");

        Intent myintent = new Intent(Intent.ACTION_VIEW,Uri.parse(""));
        PendingIntent pendingIntent= PendingIntent.getActivity(getBaseContext(),0,myintent, PendingIntent.FLAG_ONE_SHOT);
        Context context = getApplicationContext();

        Notification.Builder builder;


//        NotificationCompat.Builder mBuilder= new NotificationCompat.Builder(this);
        builder = new Notification.Builder(context)
                .setContentTitle("SALE")
                .setContentText("Sale at Kroger")
                .setContentText("Sale at Target")
                .setContentIntent(pendingIntent)
                .setNumber(10)
                .setTicker("Ticker")
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.drawable.sale1);

        Notification.BigPictureStyle bigPictureStyle= new Notification.BigPictureStyle();
       builder.setStyle(bigPictureStyle);
        bigPictureStyle.setBuilder(builder);
        //bigPictureStyle.setBigContentTitle("BigContentTitle");
        //bigPictureStyle.setSummaryText("SummaryText");
        Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.drawable.sale1);
        bigPictureStyle.bigPicture(bitmap1);
//        Bitmap bitmap2= BitmapFactory.decodeResource(getResources(), R.drawable.sale2);
//        bigPictureStyle.bigPicture(bitmap2);
//        mBuilder.setStyle(bigPictureStyle);
//        manager.notify(notifyId,mBuilder.build());
//
//        manager.notify(notifyId,mBuilder.build());
        Notification notification = builder.build();
        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(1,notification);
    }

//    private PendingIntent getDefaultIntent(int flags) {
//
//        PendingIntent pendingIntent= PendingIntent.getActivity(this,1,new Intent(),flags);
//        return pendingIntent;
//    }

    @Override
    public void onDestroy() {
//        super.onDestroy();
//        Log.d(TAG,"Service destroyed and stopped");
        try{
            mTimer.cancel();
            timerTask.cancel();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        Intent intent = new Intent("com.example.anurag_pc.shreyafinalproject.service");
        intent.putExtra("yourvalue","torestore");
        sendBroadcast(intent);

    }







    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class UpdateTask extends TimerTask {
        //private String UPDATE;

        public void run(){
            Intent intent = new Intent();
            intent.setAction(ACTION);
            intent.putExtra(UPDATE,++update);
            sendBroadcast(intent);
        }

    }
}
