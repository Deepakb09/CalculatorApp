package com.deepak.calculatorapp

import android.content.Context
import android.util.Log
import com.deepak.calculatorapp.Poko.MyObjectBox
import io.objectbox.BoxStore

object ObjectBox {

    lateinit var boxStore: BoxStore
    private set

    fun init(context: Context){

        boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()

        if (BuildConfig.DEBUG) {
            Log.d(BaseApp.TAG, "Using ObjectBox ${BoxStore.getVersion()} (${BoxStore.getVersionNative()})")
        }
    }
}