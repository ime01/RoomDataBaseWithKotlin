package com.flowz.roomdatabasewithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(applicationContext, AppDB::class.java, "EmployeeDB").allowMainThreadQueries().build()

        save_values.setOnClickListener {

            val enteredName: String = enter_name.text.toString()
            val enteredPost: String = enter_post.text.toString()
            val enteredId : Int = Integer.parseInt(enter_id.text.toString())

           // Toast.makeText(this, enteredName+ " " + enteredPost + " " + enteredId + " ", Toast.LENGTH_LONG).show()

              Thread{
                val emp = Emp_Entity()

                    emp.emp_name = enteredName

                    emp.emp_post = enteredPost

                    emp.emp_id = enteredId

                db.empDAO().saveEmp(emp)
//
//
            }.start()

            Toast.makeText(this, "Values Saved", Toast.LENGTH_LONG).show()

        }


        display.setOnClickListener {

                val read = db.empDAO().readEmp()


                read.get(2).emp_name
                read.get(2).emp_post
                read.get(2).emp_id

            val showValues: String = read.get(1).emp_name + " "+ read.get(1).emp_post + " "+ read.get(1).emp_id

           output.setText(showValues)


//            db.empDAO().readEmp().forEach {
//
////                var show1 = it.emp_name
////                var show2= it.emp_post
////                var show3 = it.emp_id
////
////                output.setText(show1 + " " + show2 + " " + show3)
//
////                Log.i("@STARK", """"Id is : ${it.emp_id}"""")
////                Log.i("@STARK", """"Name is : ${it.emp_name}"""")
////                Log.i("@STARK", """"Post is : ${it.emp_post}"""")
//
//            }
        }
    }

//    private fun readSavedValues() {
//
//        var db = Room.databaseBuilder(applicationContext, AppDB::class.java, "EmployeeDB").build()
//        val read = db.empDAO().readEmp()
//
//        read.get(1).emp_name
//        read.get(1).emp_post
//        read.get(1).emp_id
//
//        val showValues: String = read.get(1).emp_name + read.get(1).emp_post + read.get(1).emp_id
////
//        output.setText(showValues)
//    }

//    private fun saveTheValues() {
//
//        val enteredName = enter_name.text.toString()
//        val enteredPost = enter_post.text.toString()
//        val enteredId  = Integer.parseInt(enter_id.text.toString())
//
//        var db = Room.databaseBuilder(applicationContext, AppDB::class.java, "EmployeeDB").allowMainThreadQueries().build()
//
//        Thread{
//            var emp = Emp_Entity()
//            emp.emp_id = enteredId
//            emp.emp_name = enteredName
//            emp.emp_post = enteredPost
//
//            db.empDAO().saveEmp(emp)
//
//
//        }.start()
//    }
}
