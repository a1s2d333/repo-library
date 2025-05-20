package com.demo.mylibrary;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

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
    public static   void test(Context context){
        XXPermissions.with(context)
                // 申请单个权限
                .permission(Permission.RECORD_AUDIO)
                // 申请多个权限
//                .permission(Permission.Group.CALENDAR)
                // 设置权限请求拦截器（局部设置）
                //.interceptor(new PermissionInterceptor())
                // 设置不触发错误检测机制（局部设置）
                //.unchecked()
                .request(new OnPermissionCallback() {

                    @Override
                    public void onGranted(@NonNull List<String> permissions, boolean allGranted) {
                        if (!allGranted) {
                            Toast.makeText(context, "获取部分权限成功，但部分权限未正常授予", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(context, "获取录音和日历权限成功", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onDenied(@NonNull List<String> permissions, boolean doNotAskAgain) {
                        if (doNotAskAgain) {
                            Toast.makeText(context, "被永久拒绝授权，请手动授予录音和日历权限", Toast.LENGTH_SHORT).show();
                            // 如果是被永久拒绝就跳转到应用权限系统设置页面
                            XXPermissions.startPermissionActivity(context, permissions);
                        } else {
                            Toast.makeText(context, "获取录音和日历权限失败", Toast.LENGTH_SHORT).show();


                        }
                    }
                });

    }
}
