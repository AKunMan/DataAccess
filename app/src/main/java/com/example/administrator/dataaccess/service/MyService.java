package com.example.administrator.dataaccess.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private int count;
    private boolean quit;
    private MyBinder binder = new MyBinder();

    public class MyBinder extends Binder{
        public int getCount(){
            return count;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("theService","Service is Create");
        new Thread(){
            @Override
            public void run() {
                while (!quit){
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                    count++;
                }
            }
        }.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("theService","Service is stared");
        return START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("theService","Service is onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        Log.d("theService","Service is destroyed");
    }
}
