package com.test.testproject007

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.test.testproject007.ui.BookingApp
import com.test.testproject007.ui.theme.TestProject007Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestProject007Theme {
                BookingApp()
            }
        }
    }
}

