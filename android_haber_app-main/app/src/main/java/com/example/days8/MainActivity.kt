package com.example.days8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import com.example.days8.Result
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val result = Result()
        Thread {
            result
        }.start()
        // Haberleri almak için Result sınıfını kullan

        val newsList = result.news()

        // NewsAdapter sınıfı ile ListView içinde göstermek için verileri bağla
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = NewsAdapter(this, newsList)

        // Seçilen haberin URL'sini WebViewActivity sınıfına göndermek için ListView'in setOnItemClickListener yöntemini kullan
        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("href", newsList[position].href)
            startActivity(intent)
        }







    }
}