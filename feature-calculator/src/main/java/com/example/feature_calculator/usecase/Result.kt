package com.example.feature_calculator.usecase

sealed class Result {
    class Success(val result: Int) : Result()
    class Failure(val message: String) : Result()
}