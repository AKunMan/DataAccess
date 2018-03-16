package com.example.administrator.dataaccess.utils;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public static boolean saveUserInfo(String number,String password){
        return false;
    }
    public static void toastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}