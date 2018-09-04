package com.gmsdev01.myrecord;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

public class RecService extends Service {

    private static final String LOG_TAG = "Service";
    public Handler mHandler;
    private int count = 1;

    public RecService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(LOG_TAG, "Service started ");
        Toast.makeText(this, "service has started", Toast.LENGTH_LONG).show();

        Thread t = new Thread(r);
        t.start();

        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        Log.v(LOG_TAG, "Service stopped ");
        Toast.makeText(this, "service has stopped", Toast.LENGTH_LONG).show();
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            Log.v(LOG_TAG, Thread.currentThread().getId() + ": Thread started ");

            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    count = msg.arg1;
                }
            };

            if(count==1){
                for (int i = 0; i < 10; i++) {
                    Log.v(LOG_TAG, Thread.currentThread().getId() + ": " + Integer.toString(i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Log.v(LOG_TAG, Thread.currentThread().getId() + ": Thread finished ");

        }
    };
}
