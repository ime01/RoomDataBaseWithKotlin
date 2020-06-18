package com.flowz.roomdatabasewithkotlin.mvvm_example.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.flowz.roomdatabasewithkotlin.R
import kotlinx.android.synthetic.main.activity_example_coroutine.*
import kotlinx.coroutines.*

class ExampleCoroutine : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_coroutine)


        button_start.setOnClickListener {
            scope.launch {
                longRunningTask()
            }

        }

    }

    suspend fun longRunningTask(){

        delay(2000)

        Log.d("${Thread.currentThread().name}", "Response")

        printUiData("Response")

//        Thread.sleep(2000)

//        show_coroutine_result.text = show_coroutine_result.text.toString()+"\n"+"Response"
    }

    suspend fun printUiData(message:String) {

        withContext(Dispatchers.Main) {

            show_coroutine_result.text = show_coroutine_result.text.toString() + "\n" + message


        }
    }
}
