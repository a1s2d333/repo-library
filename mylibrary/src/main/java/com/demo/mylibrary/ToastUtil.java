package com.demo.mylibrary;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class ToastUtil {
    public static void showToast(Context context,String msg) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
//        EventBus.
        EventBus.getDefault().post(msg);
//        gson.toJson(msg);
    }
}
