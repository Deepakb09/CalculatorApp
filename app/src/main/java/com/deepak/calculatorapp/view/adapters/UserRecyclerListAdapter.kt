package com.deepak.calculatorapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deepak.calculatorapp.Poko.User
import com.deepak.calculatorapp.R
import com.deepak.calculatorapp.interfaces.RecyclerClickListener
import kotlinx.android.synthetic.main.recycler_user_row_view.view.*

class UserRecyclerListAdapter(var items: ArrayList<User>, val context: Context) :
    RecyclerView.Adapter<UserRecyclerListAdapter.ShowUserList>() {

    var pos: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowUserList {
        return ShowUserList(
            LayoutInflater.from(context).inflate(R.layout.recycler_user_row_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShowUserList, position: Int) {
        holder.tvUserName.tag = position

        holder.tvUserName.text = items[position].name.toString()

        /*holder.tvUserName.setOnLongClickListener(View.OnLongClickListener {

        })*/
    }

    class ShowUserList(view: View) : RecyclerView.ViewHolder(view), View.OnLongClickListener, RecyclerClickListener {

        var tvUserName = view.tvUserName
        var recyclerClickListener: RecyclerClickListener?= null

        init {
            view.setOnLongClickListener(this)
        }

        override fun onLongClick(p0: View?): Boolean {
            return true
        }

        fun setLongClickListener(recyclerClickListener: RecyclerClickListener){
            this.recyclerClickListener = recyclerClickListener
        }

        override fun onLongClick(view: View, position: Int, isLongClick: Boolean) {
            if (recyclerClickListener != null){
                recyclerClickListener!!.onLongClick(view, adapterPosition, true)
            }
        }

        override fun onClick(view: View, position: Int, isClick: Boolean) {
        }
    }
}