package com.example.test

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * This class takes care of the welcome page and its the starting page of the app
 * */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // start background music
        val svc = Intent(this, MusicService::class.java)
        startService(svc)

        var okButton: Button = findViewById(R.id.ok_button)
        okButton.setOnClickListener{
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}