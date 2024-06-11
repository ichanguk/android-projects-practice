package com.example.android_projects_practice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.example.android_projects_practice.databinding.ActivityUnitConverterBinding

class UnitConverterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnitConverterBinding

    private var cmToM = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUnitConverterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val outputTextView = binding.unitConverterOutputText
        val outputUnitTextView = binding.unitConverterOutputUnitText
        val inputUnitTextView = binding.unitConverterInputUnitText
        val inputEditText = binding.unitConverterEditText
        val swapImageButton = binding.swapImageBtn

//        if (savedInstanceState != null) {
//            cmToM = savedInstanceState.getBoolean("cmToM", true)
//            if (cmToM) {
//                inputUnitTextView.text = "cm"
//                outputUnitTextView.text = "m"
//            } else {
//                inputUnitTextView.text = "m"
//                outputUnitTextView.text = "cm"
//            }
//        }

        var inputNumber: Int = 0

        inputEditText.addTextChangedListener { text ->
            inputNumber = if (text.isNullOrEmpty()) 0 else text.toString().toInt()

            if (cmToM) {
                outputTextView.text = String.format("%.2f", inputNumber.times(0.01))
            } else {
                outputTextView.text = inputNumber.times(100).toString()
            }
        }

        swapImageButton.setOnClickListener {
            cmToM = !cmToM
            if (cmToM) {
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outputTextView.text = String.format("%.2f", inputNumber.times(0.01))
            } else {
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outputTextView.text = inputNumber.times(100).toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("cmToM", cmToM)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        cmToM = savedInstanceState.getBoolean("cmToM", true)
        binding.unitConverterInputUnitText.text = if (cmToM) "cm" else "m"
        binding.unitConverterOutputUnitText.text = if (cmToM) "m" else "cm"
        super.onRestoreInstanceState(savedInstanceState)
    }
}