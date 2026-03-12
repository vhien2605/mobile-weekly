package com.hien.myapplication.ui.component.caculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ResultCaculator(
    expression: String,
    result: String,
    isDarkMode: Boolean = false
) {
    val resultColor = if (isDarkMode) Color.White else Color.Black
    val expressionColor = if (isDarkMode) Color.LightGray else Color.Gray

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = expression,
            fontSize = 24.sp,
            color = expressionColor
        )

        Text(
            text = result,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = resultColor
        )
    }
}
