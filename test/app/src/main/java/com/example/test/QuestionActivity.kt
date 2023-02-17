package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * This class take care of the add question interface
 * */
class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        var editFieldQuestion: EditText = findViewById(R.id.editText1)
        var choicea: EditText = findViewById(R.id.editText2)
        var choiceb: EditText = findViewById(R.id.editText3)
        var choicec: EditText = findViewById(R.id.editText4)
        var editFieldAns: EditText = findViewById(R.id.editText5)

        val addBtn: Button = findViewById(R.id.add_btn)

        // simply add new question to the collection of questions via  static function addQuestion from MockQuestions
        addBtn.setOnClickListener {
            if(editFieldAns.text.toString()!="" &&
                editFieldQuestion.text.toString()!="" &&
                choicea.text.toString()!="" &&
                choiceb.text.toString()!="" &&
                choicec.text.toString()!="") {
                MockQuestions.addQuestion(
                    editFieldQuestion.text.toString(),
                    arrayListOf(
                        choicea.text.toString(),
                        choiceb.text.toString(),
                        choicec.text.toString()
                    ),
                    editFieldAns.text.toString().toInt()
                )
                Toast.makeText(this, "New question added", Toast.LENGTH_LONG).show();
                finish()
            }
        }
    }
}