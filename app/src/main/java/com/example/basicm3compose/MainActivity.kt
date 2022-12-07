package com.example.basicm3compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.basicm3compose.ui.theme.BasicM3ComposeTheme
import com.google.android.material.datepicker.MaterialDatePicker
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Both of the following are required to reproduce the issue
    WindowCompat.setDecorFitsSystemWindows(window, false)
    installSplashScreen()

    setContent {
      BasicM3ComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting("Android")
        }
      }
    }

    MaterialDatePicker.Builder.datePicker()
      .build()
      .show(supportFragmentManager, "DatePicker")
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  BasicM3ComposeTheme {
    Greeting("Android")
  }
}