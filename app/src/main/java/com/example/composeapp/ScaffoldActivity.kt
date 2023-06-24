@file:Suppress("UNUSED_EXPRESSION")

package com.example.composeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class ScaffoldActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplaySnackBar()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun DisplaySnackBar() {
    val snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) {it
        Button(onClick = {
            coroutineScope.launch {
                val snackBarResult = snackbarHostState.showSnackbar(
                    message = "This is the message",
                    actionLabel = "Undo",
                    duration = SnackbarDuration.Indefinite
                )
                when (snackBarResult) {
                    SnackbarResult.ActionPerformed -> Log.i("MYTAG", "action label clicked")
                    SnackbarResult.Dismissed -> Log.i("MYTAG", "dismissed!")
                }
            }
        }) {
            Text(text = "Display SnackBar")
        }
    }
}
