package com.example.feature_calculator.usecase
import com.example.core.utils.StringsProvider
import com.example.feature_calculator.R


class SumUseCase(stringsProvider: StringsProvider) {
    private val stringsProvider: StringsProvider = stringsProvider

    fun execute(firstNumber: Int, secondNumber: Int): Result {
        return if (firstNumber > 0 && secondNumber > 0) {
            Result.Success(firstNumber + secondNumber)
        } else {
            Result.Failure(stringsProvider.getCustomString(R.string.both_numbers_must_be_positive))
        }
    }
}