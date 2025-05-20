package com.demo.mylibrary;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class ToastUtil {
    public static void showToast(Context context,String msg) {
        String json = "{\"name\":\"张三kidou\",\"age\":24,\"emailAddress\":\"zhangsan@ceshi.com\",\"email\":\"zhangsan_2@ceshi.com\",\"email_address\":\"zhangsan_3@ceshi.com\"}";
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        Gson gson = new Gson();
        gson.toJson(json);
//        EventBus.
        EventBus.getDefault().post(msg);
        Log.i("ToastUtil", "showToast: " + msg);


//实体类
        Person p1=new Person("Tom",18,"boy");
//第二个实体类放入第一个实例类

//序列化
        String json1=gson.toJson(p1);
        System.out.println(json);
        Log.i("ToastUtil", "showToast: " + json1);

    }
}
