package com.deepak.secondmodule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.Component
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DaggerMagicBox.create().injectMain(this)

        tvFirst.text = info.text

    }
}

class Info @Inject constructor(){
    val text = "Hello Dagger 2"
}

@Component
interface MagicBox{ //MagicBox example
    fun injectMain(app: MainActivity)
}
