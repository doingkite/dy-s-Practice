package com.example.imageviewkt

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val iv_profile: ImageView = findViewById(R.id.iv_profile)

        val btn_Toast: Button = findViewById(R.id.btn_Toast)
        btn_Toast.setOnClickListener{

            iv_profile.setImageResource(R.drawable.congrats)//(R.drawable.congrats) 이미지뷰 파일경로 R--> res파일
            Toast.makeText(this@MainActivity, "버튼클릭됨", Toast.LENGTH_SHORT).show()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}