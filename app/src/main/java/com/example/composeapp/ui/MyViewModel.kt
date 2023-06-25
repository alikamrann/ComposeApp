package com.example.composeapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MyViewModel :ViewModel(){
    val myFlow = flow<Int> {
        for (i in 1..100){
            emit(i)
            delay(1000L)
        }
    }


}