package com.example.composeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ButtonDemo()
            }
        }
    }
}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
    }) {
        Text("Add To Cart")
    }

    Button(
        onClick = {
            Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
        },
        enabled = false
    ) {
        Text("Add To Cart")
    }

    TextButton(onClick = {
        Toast.makeText(context, "Clicked on Text Button", Toast.LENGTH_SHORT).show()
    }) {
        Text("Add To Cart")
    }

    OutlinedButton(onClick = {
        Toast.makeText(context, "Clicked on Out Lined Button", Toast.LENGTH_SHORT).show()
    }) {
        Text("Add To Cart")
    }

    IconButton(onClick = {
        Toast.makeText(
            context,
            "Clicked on Icon Button",
            Toast.LENGTH_SHORT
        ).show()
    }) {
        Icon(
            Icons.Filled.Refresh,
            contentDescription = "Refresh Button",
            tint = Color.DarkGray,
            modifier = Modifier.size(80.dp)
        )
    }

    Button(onClick = {
        Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
    },
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            colorResource(id = R.color.purple_200),
            contentColor = Color.White
        )
    ) {
        Text("Add To Cart",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(5.dp)
        )
    }

    Button(onClick = {
        Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
    },
        shape = CutCornerShape(10.dp),
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            colorResource(id = R.color.purple_200),
            contentColor = Color.White
        )
    ) {
        Text("Add To Cart",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(5.dp)
        )
    }

    Button(onClick = {
        Toast.makeText(context, "Clicked on Button", Toast.LENGTH_SHORT).show()
    },
        shape = CircleShape,
        contentPadding = PaddingValues(16.dp),
        border = BorderStroke(10.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            colorResource(id = R.color.purple_200),
            contentColor = Color.White
        )
    ) {
        Text("Add To Cart",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(5.dp)
        )
    }


}



























