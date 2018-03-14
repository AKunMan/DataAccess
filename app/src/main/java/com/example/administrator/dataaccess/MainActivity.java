package com.example.administrator.dataaccess;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    final String FILE_NAME = "fileDB.bin";
    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("shared_preferences",MODE_PRIVATE);
        editor = preferences.edit();

        Button setBtn = (Button)findViewById(R.id.main_act_set_btn);
        Button getBtn = (Button)findViewById(R.id.main_act_get_btn);
        setBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);

        mDatabaseHelper = new DatabaseHelper(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_act_set_btn://存数据
                //SharedPreferences
//                this.setDataWithSharedPreferences();
                //File
//                this.setDataWithFile();
                //SQLite
                this.setDataWithSQLite();

            Toast.makeText(MainActivity.this,"存入数据成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_act_get_btn://读取数据
                //SharedPreferences
//                this.getDataWithSharedPreferences();
                //File
//                this.getDataWithFile();
                //SQLite
                this.getDataWithSQLite();
                break;
            case R.id.main_act_creat_btn:
                break;

        }
    }

    private void setDataWithSharedPreferences(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日");
        editor.putString("time",sdf.format(new Date()));
        editor.putInt("random",10086);
        editor.commit();
    }
    private void getDataWithSharedPreferences(){
        String time = preferences.getString("time",null);
        int random = preferences.getInt("random",0);
        Toast.makeText(MainActivity.this,time + "+" + random,Toast.LENGTH_SHORT).show();
    }
    private void setDataWithFile(){
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME,MODE_APPEND);
            PrintStream ps = new PrintStream(fos);
            ps.println("的骄傲的骄傲了较大距离的骄傲了肯德基阿来得及阿斯加德拉时间来得及阿里京东拉丝机");
            ps.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getDataWithFile(){

        try{
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuffer sb = new StringBuffer("");
            while ((hasRead = fis.read(buff)) > 0){
                sb.append(new String(buff,0,hasRead));
            }
            Toast.makeText(MainActivity.this,sb.toString(),Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setDataWithSQLite(){
        //增
//        AddData("第一个数据");
//        AddData("第二个数据");
//        AddData("第三个数据");
        //删
        deleteData();
    }
    private void getDataWithSQLite(){
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get value from database column 1
            // then add it to ArrayList
            Log.d("1001","" + data.getInt(1));
        }
    }
    //添加数据
    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if(insertData)
            toastMessage("Data Successfully Inserted!");
        else
            toastMessage("Something went wrong :(");
    }
    //删除数据
    private void deleteData(){
        mDatabaseHelper.deleteName(0,"第一个数据");
        mDatabaseHelper.deleteName(3,"第一个数据");
        mDatabaseHelper.deleteName(6,"第一个数据");
    }
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
