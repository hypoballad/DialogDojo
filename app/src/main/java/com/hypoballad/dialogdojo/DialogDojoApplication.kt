package com.hypoballad.dialogdojo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DialogDojoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize the SDK
        // OpenAI.initialize(this, "sk-")
    }
}