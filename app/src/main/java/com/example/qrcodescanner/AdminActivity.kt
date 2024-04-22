package com.example.qrcodescanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.qrcodescanner.ui.theme.QRCodeScannerTheme

class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeScannerTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray)
                ) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                    ) {
                        IconButton(
                            onClick = {
                                val navigate = Intent(this@AdminActivity, MainActivity::class.java)
                                startActivity(navigate)
                            },
                            modifier = Modifier
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