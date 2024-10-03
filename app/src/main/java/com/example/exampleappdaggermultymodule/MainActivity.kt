package com.example.exampleappdaggermultymodule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.core.utils.AppSubscription
import com.example.exampleappdaggermultymodule.di.ApplicationComponentProvider
import com.example.feature_calculator.ui.CalculatorActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appSubscription: AppSubscription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as ApplicationComponentProvider)
            .getApplicationComponent()
            .inject(this)

        bindListeners()
    }

    private fun startCalculatorActivity() {
        startActivity(
            Intent(this, CalculatorActivity::class.java)
        )
    }

    private fun bindListeners() {
        findViewById<Button>(R.id.calculator_button).setOnClickListener {
            startCalculatorActivity()
        }
    }
}