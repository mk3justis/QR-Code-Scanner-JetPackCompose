package com.example.qrcodescanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrcodescanner.ui.theme.QRCodeScannerTheme
import com.google.zxing.MultiFormatWriter

class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QRCodeScannerTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight(.5f)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Generate QR Code:",
                            color = Color.Black,
                            style = TextStyle(fontSize = 20.sp),
                            modifier = Modifier
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 16.dp
                                    )
                        )
                        Button(
                            modifier = Modifier
                                .padding(
                                    vertical = 6.dp
                                ),
                            onClick = {

                            }
                        ) {
                            Text(text = "Generate")
                        }
                    }
                    val query = remember { mutableStateOf("") }
                    Row(
                        modifier = Modifier
                            .fillMaxSize(.8f)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        TextField(
                            value = query.value,
                            onValueChange = { query.value = it },
                            label = { Text(text = "Enter description")},
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                        )
                    }
                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(
                                    vertical = 6.dp
                                ),
                            onClick = {

                            }
                        ) {
                            Text(text = "Submit")
                        }
                    }
                    Row(
                        modifier = Modifier
                    ) {
                        IconButton(
                            onClick = {
                                val navigate = Intent(this@AdminActivity, MainActivity::class.java)
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