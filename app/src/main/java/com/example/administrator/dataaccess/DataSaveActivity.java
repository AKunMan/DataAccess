package com.example.administrator.dataaccess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class DataSaveActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etQQ;
    private EditText etPWD;
    private CheckBox cbRememberPWD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_save);

        etQQ = (EditText)findViewById(R.id.ds_QQ);
        etPWD = (EditText)findViewById(R.id.ds_PWD);
        cbRememberPWD = (CheckBox)findViewById(R.id.ds_cb_rememberPWD);

        Button loginBtn = (Button)findViewById(R.id.ds_btn_login);
        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //1、取出号码
        String qq = etQQ.getText().toString();
        String pwd = etPWD.getText().toString();
        //2、判断
        if (TextUtils.isEmpty(qq) || TextUtils.isEmpty(pwd)){
            Toast.makeText(DataSaveActivity.this,"QQ号码或密码不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        boolean rememberPwd = cbRememberPWD.isChecked();
        //3、登录
        if (rememberPwd){
            Log.d("login","记住密码登录点击");
        }else {
            Log.d("login","不记住密码登录点击");
        }
    }
}
