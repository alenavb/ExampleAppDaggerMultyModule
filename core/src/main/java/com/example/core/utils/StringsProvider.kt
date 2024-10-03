package com.example.core.utils

import android.app.Application
import androidx.annotation.StringRes


class StringsProvider(private val application: Application) {
    fun getCustomString(@StringRes id: Int?): String {
        return application.getString(id!!)
    }
}
