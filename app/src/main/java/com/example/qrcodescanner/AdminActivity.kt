package com.example.qrcodescanner

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrcodescanner.ui.theme.QRCodeScannerTheme
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import java.util.EnumMap

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
                    val query = remember { mutableStateOf("") }
                    var qrImage by remember { mutableStateOf<ImageBitmap?>(null) }
                    val focusManager = LocalFocusManager.current
                    val screenWidth = LocalConfiguration.current.screenWidthDp

                    Row(
                        modifier = Modifier
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
                                val text = query.value
                                val size = 360
                                val bitmap = generateQRCode(text, size)
                                bitmap?.let {
                                    qrImage = it.asImageBitmap()
                                }
                            }
                        ) {
                            Text(text = "Generate")
                        }
                    }
                    Row {
                        qrImage?.let { image ->
                            Image(
                                bitmap = image,
                                contentDescription = "QR Code",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(.5f)
                                    .padding(32.dp, 32.dp)
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    ) {
                        TextField(
                            value = query.value,
                            onValueChange = { query.value = it },
                            label = { Text(text = "Enter description") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(.4f),
                            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                            keyboardActions = KeyboardActions(onDone = {
                                focusManager.clearFocus()
                            })
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

    private fun generateQRCode(text: String, size: Int): Bitmap {
        val hints: MutableMap<EncodeHintType, Any> = EnumMap(EncodeHintType::class.java)
        hints[EncodeHintType.MARGIN] = 0 // Adjust margin as needed

        try {
            val writer = QRCodeWriter()
            val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size, hints)
            val width = bitMatrix.width
            val height = bitMatrix.height
            val bmp = android.graphics.Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.RGB_565)

            for (x in 0 until width) {
                for (y in 0 until height) {
                    bmp.setPixel(x, y, if (bitMatrix[x, y]) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
                }
            }
            return bmp
        } catch (e: WriterException) {
            // Handle exception
            return android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.RGB_565)
        }
    }

}