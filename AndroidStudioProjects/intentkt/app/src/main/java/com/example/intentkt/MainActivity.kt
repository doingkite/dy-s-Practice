package com.example.intentkt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var et_sendMsg: TextView = findViewById(R.id.et_sendMsg)

        val btn_a: Button = findViewById(R.id.btn_a)
        btn_a.setOnClickListener{
            //var: 값이 언제든지 변경 가능한 변수, val: 자바에서는 final.. 값이 변경되지 못하는 변수

            val intent = Intent(this, SubActivity::class.java)// 다음화면으로 이동하기 위한 인텐트 객체 생성
            intent.putExtra("msg", et_sendMsg.text.toString())//hello world라는 텍스트를 담고 msg라는 키로 잠궜다
            startActivity(intent)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}