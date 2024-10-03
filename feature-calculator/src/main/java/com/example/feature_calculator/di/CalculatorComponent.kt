package com.example.feature_calculator.di

import com.example.core.di.CoreModule
import com.example.feature_calculator.ui.CalculatorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CalculatorModule::class,
        CoreModule::class
    ]
)
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)
}