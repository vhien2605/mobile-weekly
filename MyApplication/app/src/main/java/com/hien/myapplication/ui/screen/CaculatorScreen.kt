package com.hien.myapplication.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hien.myapplication.ui.component.caculator.DisplaySection
import com.hien.myapplication.ui.component.caculator.InputSection
import com.hien.myapplication.viewmodel.CalculatorViewModel


@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state = viewModel.state
    val backgroundColor = if (state.isDarkMode) Color(0xFF1C1C1E) else Color.White

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(onClick = { viewModel.onInput("toggle_theme") }) {
                    Text(
                        text = if (state.isDarkMode) "☀️" else "🌙",
                        fontSize = 24.sp
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                DisplaySection(
                    expression = state.expression,
                    result = state.result,
                    isDarkMode = state.isDarkMode
                )
                Spacer(modifier = Modifier.height(12.dp))
                InputSection(
                    onInput = { value -> viewModel.onInput(value) },
                    isDarkMode = state.isDarkMode
                )
            }
        }
    }
}
