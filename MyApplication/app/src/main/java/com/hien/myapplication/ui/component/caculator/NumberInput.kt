package com.hien.myapplication.ui.component.caculator

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun NumberInput(
    number: String,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false
) {
    val containerColor = if (isDarkMode) Color(0xFF333333) else Color(0xFFF1F3F4)
    val contentColor = if (isDarkMode) Color.White else Color.Black

    Button(
        onClick = { onClick(number) },
        modifier = modifier.size(72.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        Text(
            text = number,
            fontSize = 20.sp
        )
    }
}
