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

class CorrectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val message = intent.getStringExtra("message") ?: ""
        setContent {
            CorrectScreen(message = message)
        }
    }
}

@Composable
fun CorrectScreen(message: String) {
    val context = LocalContext.current
    val verticalText = message.map { it.toString() }.joinToString("\n")
    val chooserTitle = stringResource(R.string.choose_app)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(stringResource(R.string.correct))
        Text(verticalText)

        Button(onClick = {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, verticalText)
            }
            val chooser = Intent.createChooser(sendIntent, chooserTitle)
            context.startActivity(chooser)
        }) {
            Text(stringResource(R.string.send_email_button))
        }
    }
}
