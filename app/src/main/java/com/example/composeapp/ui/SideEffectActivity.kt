package com.example.composeapp.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.ui.theme.EffectsDemo1Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class SideEffectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectsDemo1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current
) {
    var round by remember { mutableStateOf(1) }
    var total by remember { mutableStateOf(0.0) }
    var input by remember { mutableStateOf("") }

    val coroutineScope : CoroutineScope = rememberCoroutineScope()



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = "Total is ${total.toString()}",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.DarkGray
            )
            OutlinedTextField(
                modifier = modifier.fillMaxWidth(),
                placeholder = { Text("Enter value here") },
                value = input,
                onValueChange = {
                    input = it
                },
                textStyle = TextStyle(
                    color = Color.LightGray,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                label = { Text(text = "New count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                modifier = modifier.fillMaxWidth(),
                onClick = {
                    total += input.toDouble()
                    coroutineScope.launch {

                    }
                    if(total>300){
                        total = 0.0
                        input = ""
                        round++
                    }
                }
            ) {
                Text(
                    text = "Count",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }


