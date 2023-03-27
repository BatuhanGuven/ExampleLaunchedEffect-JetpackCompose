package com.example.constraintlayout_androidjetpackcompose_part9

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExampleLaunchedEffect()

        }
    }
}
@Composable
fun ExampleLaunchedEffect() {
    val showToast = remember { mutableStateOf(false) }
    var toastMessage by remember { mutableStateOf("") }

    Button(onClick = {
        toastMessage = "Hello World!"
        showToast.value = true
    }) {
        Text(text = "Show Toast")
    }

    if (showToast.value) {
        val context = LocalContext.current
        LaunchedEffect(showToast.value) {
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            showToast.value = false
        }
    }
}
