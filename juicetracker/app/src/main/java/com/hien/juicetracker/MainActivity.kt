package com.hien.juicetracker

// MainActivity.kt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.hien.juicetracker.ui.screen.JuiceTrackerScreen
import com.hien.juicetracker.viewmodel.JuiceViewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<JuiceViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Bạn có thể định nghĩa Theme riêng để khớp mã màu tím trong ảnh
            MaterialTheme {
                Surface {
                    JuiceTrackerScreen(viewModel = viewModel)
                }
            }
        }
    }
}