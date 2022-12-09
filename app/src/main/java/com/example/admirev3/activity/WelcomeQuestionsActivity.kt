package com.example.admirev3.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.admirev3.R

class WelcomeQuestionsActivity : AppCompatActivity() {
    private var questionsCounter = 0 // keeps track of the questions
    private var positive = 0 // keeps track of the positive answers
    private lateinit var tvQuestions: TextView
    private lateinit var btnPositive: Button
    private lateinit var btnNegative: Button

    private val questions = arrayOf(R.string.a, R.string.b, R.string.c, R.string.d, R.string.e)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_questions)

        // view binding
        tvQuestions = findViewById(R.id.tvQuestions)
        btnPositive = findViewById(R.id.btnPositive)
        btnNegative = findViewById(R.id.btnNegative)

        // buttons
        btnPositive.setOnClickListener {
            positive++
            updateQuestions()
        }
        btnNegative.setOnClickListener {
            updateQuestions()
        }
    }

    private fun updateQuestions() {
        tvQuestions.setText(questions[questionsCounter])

        if (questionsCounter == 5) {
            if (positive >= 3) {
                Toast.makeText(this, "happy", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "sad", Toast.LENGTH_SHORT).show()
            }
        }
        questionsCounter++
        return
    }
}