package com.example.composeapp.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    val myFlow = flow<Int> {
        for (i in 1..100) {
            emit(i)
            delay(1000L)
        }
    }

    init {
        backPressureDemo()
    }

    private fun backPressureDemo() {
        val myFlow1 = flow<Int> {
            for (i in 1..10) {
                Log.i("MYTAG", "Produced $i")
                emit(i)
                delay(1000L)
            }
        }

        viewModelScope.launch {
//            myFlow1.buffer().collect{
            myFlow1.filter { i ->
                i % 3 == 0
            }.map { it ->
                showMessage(it)
            }.collect {
                Log.i("MYTAG", "Consumed $it")
            }
        }


    }

    fun showMessage(count: Int): String {
        return "Hello $count"
    }
}