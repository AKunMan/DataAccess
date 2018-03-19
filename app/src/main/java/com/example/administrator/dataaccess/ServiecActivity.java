package com.example.administrator.dataaccess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.dataaccess.service.MyService;

public class ServiecActivity extends AppCompatActivity implements View.OnClickListener{

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
                startService(serviceIntent);
                break;
            case R.id.service_act_stop_btn:
                //停止service
                stopService(serviceIntent);
                break;
            case R.id.service_act_get_btn:
                break;

        }
    }
}
