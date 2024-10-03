package com.example.core.di

import com.example.core.utils.AppSubscription
import com.example.core.utils.StringsProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CoreModule::class])
class SubscriptionModule {

    @Provides
    @Singleton
    fun appSubscription(
        stringsProvider: StringsProvider
    ): AppSubscription = AppSubscription(stringsProvider)

}