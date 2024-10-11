package com.example.listviewkt

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var UserList = arrayListOf<User>(
        User(R.drawable.free_icon_user_profile_6325242, "최상여보자기", "31", "루시입니당"),
        User(R.drawable.free_icon_user_profile_6325242, "신녜찬", "33", "설이아빠"),
        User(R.drawable.free_icon_user_profile_6325242, "안태규", "25", "드포입니당"),
        User(R.drawable.free_icon_user_profile_6325242, "조원땅", "29", "베이시스트"),
        User(R.drawable.free_icon_user_profile_6325242, "팡일", "28", "드러머"),
        User(R.drawable.free_icon_user_profile_6325242, "짱경민", "29", "랔후나"),
        User(R.drawable.free_icon_user_profile_6325242, "나상현", "33", "나상니면상"),
        User(R.drawable.free_icon_user_profile_6325242, "편성현", "23", "아기")


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        val listView: ListView = findViewById(R.id.listView)
        val Adapter =UserAdapter(this,UserList)
        listView.adapter = Adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }


//        val listView: ListView = findViewById(R.id.listView)
//        val item = arrayOf("태규", "상엽", "예찬", "원상")
//
//        // context란 한 액티비티의 모든 정보를 담고 있음.
//        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, item)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}