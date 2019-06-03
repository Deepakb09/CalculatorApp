package com.deepak.calculatorapp.interfaces

import android.view.View

interface RecyclerClickListener {
    fun onClick(view: View, position: Int, isClick: Boolean)
    fun onLongClick(view: View, position: Int, isLongClick: Boolean)
}