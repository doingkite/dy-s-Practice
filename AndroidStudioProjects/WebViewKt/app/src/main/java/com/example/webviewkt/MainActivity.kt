package com.example.webviewkt

import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView // 전역 변수로 선언, 변수를 나중에 초기화할 것임을 명시하는 데 사용됩니다. 주로 val이나 var로 선언된 비널리 변수를 초기화할 수 없는 상황에서 사용

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        webView.settings.javaScriptEnabled = true //자바스크립트 허용

        /* 웹뷰에서 새창이 뜨지 않도록 하는 구문*/
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        webView.loadUrl("http://www.naver.com") //링크 주소 로드


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


    }

    override fun onBackPressed() {//웹사이트에서 뒤로 갈 페이지가 있다면
        if(webView.canGoBack()){
            webView.goBack() //웹사이트 뒤로 가기
        }
        else{
            super.onBackPressed() // 기본 동작 수행 (안드로이드의 본래 백버튼)
        }
    }
}