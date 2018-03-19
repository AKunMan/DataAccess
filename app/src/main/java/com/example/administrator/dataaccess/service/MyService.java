package com.example.administrator.dataaccess.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("theService","Service is Create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("theService---1083","Service is stared");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("theService---1083","Service is destroyed");
    }
}
