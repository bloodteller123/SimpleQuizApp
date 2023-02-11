package com.example.test

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var okButton: Button = findViewById(R.id.ok_button)
        val svc = Intent(this, MusicService::class.java)
        startService(svc)

        okButton.setOnClickListener{
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}