package com.example.composeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.composeapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

        val textView = findViewById<TextView>(R.id.textView)

        val myFlow = flow<Int>{
            for (i in 1..100){
                emit(i)
                delay(1000L)
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            myFlow.collect{
                textView.text = "Current index is $it"
            }
        }
    }
}