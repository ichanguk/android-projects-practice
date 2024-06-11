package com.example.android_projects_practice

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CountNumActivity : AppCompatActivity() {
    var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_count_num)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        if (savedInstanceState != null) {
            number = savedInstanceState.getInt("NUMBER_KEY", 0)
        }

        val numberTextView = findViewById<TextView>(R.id.number_text)
        val resetButton = findViewById<Button>(R.id.reset_btn)
        val plusButton = findViewById<Button>(R.id.plus_btn)

        numberTextView.text = number.toString()

        resetButton.setOnClickListener {
            number = 0
            numberTextView.text = number.toString()
        }

        plusButton.setOnClickListener {
            number++
            numberTextView.text = number.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("NUMBER_KEY", number)
    }
}