package com.example.administrator.dataaccess;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.dataaccess.service.MyService;
import com.example.administrator.dataaccess.utils.Utils;

public class ServiecActivity extends AppCompatActivity implements View.OnClickListener{

    MyService.MyBinder binder;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("theService","Service Connected");
            binder = (MyService.MyBinder) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("theService","Service Disconnected");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviec);

        Button starBtn = (Button)findViewById(R.id.service_act_star_btn);
        Button stopBtn = (Button)findViewById(R.id.service_act_stop_btn);
        Button getBtn = (Button)findViewById(R.id.service_act_get_btn);
        starBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        Intent serviceIntent = new Intent(ServiecActivity.this, MyService.class);
        switch (view.getId()){
            case R.id.service_act_star_btn:
                //启动service
//                startService(serviceIntent);
                bindService(serviceIntent,conn,Service.BIND_AUTO_CREATE);
                break;
            case R.id.service_act_stop_btn:
                //停止service
//                stopService(serviceIntent);
                unbindService(conn);
                break;
            case R.id.service_act_get_btn:
                Utils.toastMessage(ServiecActivity.this,"service的值"+binder.getCount());
                break;

        }
    }
}
