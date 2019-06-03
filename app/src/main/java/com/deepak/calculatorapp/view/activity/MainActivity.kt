package com.deepak.calculatorapp.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.deepak.calculatorapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var result: Double? = 0.0
    var num1: Double? = 0.0
    var num2: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAdd.setOnClickListener(View.OnClickListener {
            num1 = etFirstNo.text.toString().toDouble()
            num2 = etSecNo.text.toString().toDouble()
            result = num1!! + num2!!
            tvResult.text = result.toString()
        })

        btSubtract.setOnClickListener(View.OnClickListener {
            num1 = etFirstNo.text.toString().toDouble()
            num2 = etSecNo.text.toString().toDouble()
            result = num1!! - num2!!
            tvResult.text = result.toString()
        })

        btMultiply.setOnClickListener(View.OnClickListener {
            num1 = etFirstNo.text.toString().toDouble()
            num2 = etSecNo.text.toString().toDouble()
            result = num1!! * num2!!
            tvResult.text = result.toString()
        })

        btDivide.setOnClickListener(View.OnClickListener {
            num1 = etFirstNo.text.toString().toDouble()
            num2 = etSecNo.text.toString().toDouble()
            result = num1!! / num2!!
            tvResult.text = result.toString()
        })

        btNextScreen.setOnClickListener(View.OnClickListener {
            moveToRecyclerActivity()
        })

        btNextModule.setOnClickListener(View.OnClickListener {
            val nextModule = Intent(this, Class.forName("com.deepak.secondmodule.MainActivity"))
            startActivity(nextModule)
        })
    }

    fun moveToRecyclerActivity(){
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }
}
