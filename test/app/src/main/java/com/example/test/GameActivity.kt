package com.example.test

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class GameActivity : AppCompatActivity(), View.OnClickListener {
    private var score: Int = 0
    private lateinit var index: MutableSet<Int>
    private var setInd: Int = 0;

    private lateinit var question: TextView

    private lateinit var c1: Button
    private lateinit var c2: Button
    private lateinit var c3: Button
    private lateinit var submitBtn: Button

    private lateinit var ll: LinearLayout
    private lateinit var rl: RelativeLayout

    private lateinit var qs: List<String>
    private lateinit var cs: List<List<String>>
    private lateinit var ans: List<Int>

    private lateinit var selections: MutableList<Int>
    private var selectedChoice: Int = -1
    private var isViewed: Boolean = false

    private val sharedPrefs by lazy{ getSharedPreferences("preferences", Context.MODE_PRIVATE)}
    private lateinit var screenColor: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    override fun onStart() {
        super.onStart()
        val mq: MockQuestions =  MockQuestions()
        qs = mq.getQuestions()
        cs = mq.getChoices()
        ans = mq.getAnswers()

        c1 = findViewById(R.id.choice_a)
        c2 = findViewById(R.id.choice_b)
        c3 = findViewById(R.id.choice_c)
        submitBtn = findViewById(R.id.submit_btn)
        ll = findViewById(R.id.choices)
        rl = findViewById(R.id.layout)

        question = findViewById(R.id.question)
        selections = arrayListOf()

        c1.setOnClickListener(this)
        c2.setOnClickListener(this)
        c3.setOnClickListener(this)
        submitBtn.setOnClickListener(this)
        index = mutableSetOf<Int>()
        screenColor = mutableListOf(Color.YELLOW, Color.GRAY, Color.MAGENTA, Color.WHITE)

        val nums:Int = qs.size-1
        while(index.size<4){
            val rnds = (0..nums).random()
            index.add(rnds)
        }
        startGame()
    }

    private fun startGame(){
        loadNextQuestion()
    }

    override fun onClick(view: View?) {

        c1.setBackgroundColor(Color.WHITE)
        c2.setBackgroundColor(Color.WHITE)
        c3.setBackgroundColor(Color.WHITE)
        if(!isViewed) {
            when (view?.id) {
                R.id.submit_btn -> {
                    if (selectedChoice != -1) {
                        selections.add(selectedChoice)
                        val ind: Int = index.elementAt(setInd)
                        if (cs[ind][ans[ind]] == (ll.getChildAt(selectedChoice) as Button).text) {
                            score++
                        }
                        selectedChoice = -1
                        setInd++
                        loadNextQuestion()
                    }
                }
                else -> {
                    selectedChoice = ll.indexOfChild(view)
                    Log.d("ind", selectedChoice.toString())
                    view?.setBackgroundColor(Color.CYAN)
                }
            }
        }
        else if(view?.id == R.id.submit_btn){
            loadNextQuestion()
        }
    }

    private fun loadNextQuestion() {

        if(setInd != index.size) {
            val ind: Int = index.elementAt(setInd)
            rl.setBackgroundColor(screenColor[setInd])
            question.text = qs[ind]
            c1.text = cs[ind][0]
            c2.text = cs[ind][1]
            c3.text = cs[ind][2]

            // if app enters "view-all-question" mode
            if(isViewed){
                submitBtn.text = "Next Question"
                val sc: Int = selections[setInd]
                Log.d("Selection", sc.toString())
                Log.d("Answer", ans[ind].toString())
                var sBtn: Button = ll.getChildAt(sc) as Button
                var ansBtn: Button = ll.getChildAt(ans[ind]) as Button
                if(ans[ind] != sc){
                    sBtn.setBackgroundColor(Color.RED)
                }
                ansBtn.setBackgroundColor(Color.GREEN)
                setInd++
            }
        }else{
            end()
        }
    }
    private fun end(){
        val editor: SharedPreferences.Editor =  sharedPrefs.edit()
        editor.putInt("score",score)
        editor.apply()
        editor.commit()
        buildDialog(score.toString())
    }

    private fun buildDialog(str: String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder?.setMessage("You score $str in this round")
            ?.setCancelable(false)
            ?.setNeutralButton("Back") { _, _ ->
                //do things
                var intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
            ?.setPositiveButton("View answers") { _, _ ->
                setInd = 0
                isViewed = true
                loadNextQuestion()
            }
            ?.setTitle("Score")
        val alert: AlertDialog = builder.create()
        alert.show()
    }

}