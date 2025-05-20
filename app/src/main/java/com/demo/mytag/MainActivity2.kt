package com.demo.mytag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.demo.mylibrary.ToastUtil

class MainActivity2 : AppCompatActivity() {
    lateinit var  btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ToastUtil.showToast(this,"haha");
//        ToastUtil.test(this)
        btn=findViewById(R.id.btn)
        btn.setOnClickListener {
            ToastUtil.showToast(this,"haha");
            ToastUtil.test(this)
        }
    }
}