package com.deepak.calculatorapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deepak.calculatorapp.Poko.Employee
import com.deepak.calculatorapp.R
import kotlinx.android.synthetic.main.recycler_row_view.view.*

class RecyclerAdapter(val items: ArrayList<Employee>, val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ShowDataHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowDataHolder {
        return ShowDataHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recycler_row_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShowDataHolder, position: Int) {
        holder.tvName.text = items.get(position).name
        holder.tvMobile.text = items.get(position).mobile
        holder.tvEmail.text = items.get(position).email
        holder.tvAge.text = items.get(position).age
    }

    class ShowDataHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.tvName
        val tvMobile = view.tvMobile
        val tvEmail = view.tvEmail
        val tvAge = view.tvAge
    }
}