package com.deepak.calculatorapp.view.activity

import com.deepak.calculatorapp.Poko.Employee
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.deepak.calculatorapp.R
import com.deepak.calculatorapp.view.adapters.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    val employeeDetails : ArrayList<Employee> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        addEmployees()

        rvEmployee.layoutManager = LinearLayoutManager(this)

        rvEmployee.adapter = RecyclerAdapter(employeeDetails, this)

        btNextScreen.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, RetrofitActivity::class.java)
            startActivity(intent)
        })
    }

    fun addEmployees(){
        var emp1 = Employee("abc", "123456", "abc@gmail.com", "20")
        var emp2 = Employee("def", "734234", "def@gmail.com", "25")
        var emp3 = Employee("ijk", "364775", "ijk@gmail.com", "27")
        var emp4 = Employee("mno", "455522", "mno@gmail.com", "28")
        var emp5 = Employee("xyz", "645425", "xyz@gmail.com", "27")

        employeeDetails.add(emp1)
        employeeDetails.add(emp2)
        employeeDetails.add(emp3)
        employeeDetails.add(emp4)
        employeeDetails.add(emp5)

    }
}
