package com.example.exampleappdaggermultymodule

import android.app.Application
import com.example.core.di.CoreModule
import com.example.exampleappdaggermultymodule.di.ApplicationComponent
import com.example.exampleappdaggermultymodule.di.ApplicationComponentProvider
import com.example.exampleappdaggermultymodule.di.DaggerApplicationComponent
import com.example.feature_calculator.di.CalculatorComponent
import com.example.feature_calculator.di.CalculatorComponentProvider
import com.example.feature_calculator.di.DaggerCalculatorComponent

class MyApp : Application(),
    CalculatorComponentProvider,
    ApplicationComponentProvider {

    private val coreModule: CoreModule by lazy {
        CoreModule(this)
    }

    override fun getCalculatorComponent(): CalculatorComponent {
        return DaggerCalculatorComponent.builder()
            .coreModule(coreModule)
            .build()
    }

    override fun getApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
            .coreModule(coreModule)
            .build()
    }

}