package com.example.feature_calculator.ui

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_calculator.R
import com.example.feature_calculator.usecase.Result
import com.example.feature_calculator.usecase.SumUseCase
import com.example.feature_calculator.di.CalculatorComponentProvider
import javax.inject.Inject

class CalculatorActivity : AppCompatActivity() {

    @Inject
    lateinit var sumUseCase: SumUseCase

    lateinit var firstNumberEditText: EditText
    lateinit var secondNumberEditText: EditText
    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        (application as CalculatorComponentProvider)
            .getCalculatorComponent()
            .inject(this)

        bindViews()
        bindListeners()
    }

    private fun calculateSum() {
        val firstNumberString = firstNumberEditText.text.toString()
        val secondNumberString = secondNumberEditText.text.toString()

        if(TextUtils.isEmpty(firstNumberString) ||
            TextUtils.isEmpty(secondNumberString)) {
            showFailureMessage(getString(R.string.both_numbers_must_have_value))
        } else {
            sumUseCase.execute(firstNumberString.toInt(), secondNumberString.toInt()).let {
                when (it) {
                    is Result.Success -> resultTextView.text = it.result.toString()
                    is Result.Failure -> showFailureMessage(it.message)
                }
            }
        }
    }

    private fun showFailureMessage(message: String) {
        resultTextView.text = ""
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun bindViews() {
        firstNumberEditText = findViewById(R.id.first_number_edittext)
        secondNumberEditText = findViewById(R.id.second_number_edittext)
        resultTextView = findViewById(R.id.result_textview)
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.button_calculate).setOnClickListener {
            calculateSum()
        }
    }
}