package com.example.qrcodescanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.qrcodescanner.ui.theme.QRCodeScannerTheme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeScannerTheme {
                Column {
                    Row(
                        modifier = Modifier
                            .background(color = Color.Gray)
                    ) {
                        IconButton(
                            onClick = {
                                val navigate = Intent(this@SettingsActivity, MainActivity::class.java)
                                startActivity(navigate)
                            },
                            modifier = Modifier
                                .fillMaxHeight(1f)
                                .weight(1f),
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "User Page"
                            )
                        }
                    }
                }
            }
        }
    }
}

