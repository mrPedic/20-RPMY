package com.example.a20_rpmy

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            var input by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = input,
                    onValueChange = { input = it },
                    label = { Text(stringResource(R.string.enter_hint)) }
                )

                Button(onClick = {
                    val intent = if (input == "Ващило") {
                        Intent(context, CorrectActivity::class.java)
                            .putExtra("message", input)
                    } else {
                        Intent(context, WrongActivity::class.java)
                    }
                    context.startActivity(intent)
                }) {
                    Text(stringResource(R.string.send_button))
                }
            }
        }
    }
}
