package com.deepak.calculatorapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deepak.calculatorapp.R
import kotlinx.android.synthetic.main.activity_collapsing_toolbar.*

class CollapsingToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsing_toolbar)
        setSupportActionBar(toolbar)

        toolbar.title = "You forgot some required fields"
    }
}
