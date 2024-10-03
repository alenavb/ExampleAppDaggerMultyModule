package com.example.feature_calculator.di

import com.example.core.utils.StringsProvider
import com.example.feature_calculator.usecase.SumUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CalculatorModule {

    @Provides
    @Singleton
    fun sumUseCase(
        stringsProvider: StringsProvider
    ): SumUseCase = SumUseCase(stringsProvider)

}