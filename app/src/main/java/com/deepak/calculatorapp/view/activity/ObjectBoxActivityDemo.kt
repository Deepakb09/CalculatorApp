package com.deepak.calculatorapp.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deepak.calculatorapp.ObjectBox
import com.deepak.calculatorapp.Poko.User
import com.deepak.calculatorapp.Poko.User_
import com.deepak.calculatorapp.R
import com.deepak.calculatorapp.view.adapters.UserRecyclerListAdapter
import io.objectbox.Box
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import io.objectbox.query.Query
import kotlinx.android.synthetic.main.activity_object_box_demo.*

class ObjectBoxActivityDemo : AppCompatActivity() {

    private lateinit var usersBox: Box<User>
    private lateinit var userQuery: Query<User>
    var usernamesList: ArrayList<User> = ArrayList()

    var recyclerAdapter: UserRecyclerListAdapter? = null
    var recyclerLayoutManager: LinearLayoutManager?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_box_demo)

        usersBox = ObjectBox.boxStore.boxFor()

        userQuery = usersBox.query {
            order(User_.name)
        }

        recyclerLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvUsersList.layoutManager = recyclerLayoutManager
        recyclerAdapter = UserRecyclerListAdapter(usernamesList, this)
        rvUsersList.adapter = recyclerAdapter

        /*rvUsersList.apply {
            recyclerLayoutManager
            recyclerAdapter
        }*/

        btAddUser.setOnClickListener(View.OnClickListener {
            addUser()
        })

        btShowUser.setOnClickListener(View.OnClickListener {
            //updateTextBox()
            readUsersforDB()
        })

        btDeleteUser.setOnClickListener(View.OnClickListener {
            setRecyclerViewItemTouchListener()
        })

    }

    fun addUser(){
        val user = User(name = etUserName.text.toString())
        usersBox.put(user)
        etUserName.setText("")
    }

    fun readUsersforDB(){
        usernamesList = userQuery.find() as ArrayList<User>
        recyclerAdapter = UserRecyclerListAdapter(usernamesList, this)
        rvUsersList.adapter = recyclerAdapter
        recyclerAdapter!!.notifyDataSetChanged()
    }

    private fun setRecyclerViewItemTouchListener() {

        //1
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder): Boolean {
                //2
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                //3
                val position = viewHolder.adapterPosition
                usernamesList.removeAt(position)
                rvUsersList.adapter!!.notifyItemRemoved(position)
            }
        }

        //4
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(rvUsersList)
    }
}
