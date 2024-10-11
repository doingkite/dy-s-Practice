package com.example.realfirstapplication

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { //앱 최초 실행 시 수행
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //xml 화면뷰 연결

        val tv_title: TextView = findViewById(R.id.tv_title)
        tv_title.text = "Hello World!"

        val btn_getText: Button = findViewById(R.id.btn_getText) // Correctly reference the button
        val et_id: EditText = findViewById(R.id.et_id)

        btn_getText.setOnClickListener { // Add a click listener
            // Define what happens when the button is clicked
            var resultText= et_id.text.toString()
            tv_title.text = "Button clicked!"

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }}