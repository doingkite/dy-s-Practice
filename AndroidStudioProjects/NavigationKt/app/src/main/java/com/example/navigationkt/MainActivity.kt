package com.example.navigationkt

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var layout_drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout_drawer: DrawerLayout = findViewById(R.id.layout_drawer)
        val btn_navi: ImageView = findViewById(R.id.btn_navi)

        btn_navi.setOnClickListener {
            layout_drawer.openDrawer(GravityCompat.START)// start: left, End: right 동의어
        }
        val naviView: NavigationView = findViewById(R.id.naviView)
        naviView.setNavigationItemSelectedListener(this)
        
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 메뉴 아이템 클릭 시 수행
        when (item.itemId)
        {
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()
            
        }

        layout_drawer.closeDrawers()//네비게이션 뷰 닫기
        return false
    }
}
