package com.example.test

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog.Builder


class MenuActivity : AppCompatActivity() {
    private val sharedPrefs by lazy{ getSharedPreferences("preferences", Context.MODE_PRIVATE)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var okButton: Button = findViewById(R.id.start_btn)
        okButton.setOnClickListener{
            var intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        var scoreButton: Button = findViewById((R.id.score_btn))
        scoreButton.setOnClickListener{
            //sharedPreferences here

            buildDialog(sharedPrefs.getInt("score",0).toString())
        }

        var backBtn: Button = findViewById(R.id.back_btn)
        backBtn.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var addBtn: Button = findViewById(R.id.addQuestion_btn)
        addBtn.setOnClickListener {
            var intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buildDialog(str: String){
        val builder: Builder = Builder(this)
        builder?.setMessage("You scored $str in last round")
            ?.setCancelable(false)
            ?.setPositiveButton("OK", DialogInterface.OnClickListener {_, id ->
                //do things
            })
            ?.setTitle("Scores")
        val alert: AlertDialog = builder.create()
        alert.show()
    }
}