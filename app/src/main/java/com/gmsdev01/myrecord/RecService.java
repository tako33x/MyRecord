package com.gmsdev01.myrecord;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class RecService extends Service {

    private static final String LOG_TAG = "Service";


    public RecService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v(LOG_TAG, "Service started ");
        Toast.makeText(this, "service has started",Toast.LENGTH_LONG).show();

        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        Log.v(LOG_TAG, "Service stopped ");
        Toast.makeText(this, "service has stopped",Toast.LENGTH_LONG).show();
    }
}
