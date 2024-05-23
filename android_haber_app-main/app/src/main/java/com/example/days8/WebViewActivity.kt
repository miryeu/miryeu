package com.example.days8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val href = intent.getStringExtra("href")

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(href!!)
    }
}