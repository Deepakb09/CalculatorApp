package com.deepak.calculatorapp

import android.app.Application

class BaseApp : Application() {
    companion object Constants {
        const val TAG = "ObjectBoxExample"
    }

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
    }
}