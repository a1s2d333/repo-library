package com.demo.mytag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.mylibrary.ToastUtil

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ToastUtil.showToast(this,"haha");

    }
}