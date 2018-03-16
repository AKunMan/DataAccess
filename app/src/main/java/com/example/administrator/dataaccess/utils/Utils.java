package com.example.administrator.dataaccess.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    //存储用户信息
    public static boolean saveUserInfo(String number, String password) {
        String inputStr = number + "##" + password;
        boolean isSuccess;
        isSuccess = setDataWithSharedPreferences(inputStr);
        return isSuccess;
    }

    public static boolean setDataWithSharedPreferences(String inputStr) {
        try {
            String path = "data/data/com.example.administrator.dataaccess/qqSave.txt";
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(inputStr.getBytes());
            fos.flush();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //返回用户信息
    public static Map<String, String> getUserInfo() {
        try {
            String path = "data/data/com.example.administrator.dataaccess/qqSave.txt";
            FileInputStream fis = new  FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String text = reader.readLine();
            if (!text.isEmpty()){
                String[] spilt = text.split("##");
                if (spilt.length > 0){
                    Map<String,String> userInfoMap = new  HashMap<String,String>();
                    userInfoMap.put("qq",spilt[0]);
                    userInfoMap.put("pwd",spilt[1]);
                    return userInfoMap;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void toastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}