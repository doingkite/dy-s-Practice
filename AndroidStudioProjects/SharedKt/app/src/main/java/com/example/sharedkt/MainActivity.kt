package com.example.sharedkt

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var et_Hello: EditText // 전역 변수로 선언

    override fun onCreate(savedInstanceState: Bundle?) { //앱이 처음 실행될 떄 한번 수행하는 곳 (초기화)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        et_Hello = findViewById(R.id.et_Hello) // 초기화

        //TODO: 저장된 데이터 로드하기 //edit text 저장되어있던 것을 settext

        loadData()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun loadData() {
        val pref = getSharedPreferences("pref", 0)
        et_Hello.setText(pref.getString("name", "")) // 첫번재 인자에서는 저장할 당시의 키 값을 적어줄, 두번쨰는 키 값에 데이터가 존재하지 않을 경우 대체값을 적는다.
    }

    override fun onDestroy() { //액티비티가 종료되는 시점이 다가올때 호출
        super.onDestroy()

        saveData() //edit text 값을 저장
    }

    private fun saveData() { //getSharedPreference 앱을 실행하지 않아도 데이터베이스가 저장되어있음
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit() // 수정모드
        edit.putString("name", et_Hello.text.toString()) // 첫번쨰 인자: 키 값, 두번째 인자: 실제 담아올 값
        edit.apply() //저장완
    }
}