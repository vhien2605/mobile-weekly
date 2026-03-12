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
fun OperationInput(
    symbol: String,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false
) {
    val containerColor = when (symbol) {
        "C", "del", "%" -> if (isDarkMode) Color(0xFFA5A5A5) else Color(0xFFD2D3D5)
        "=" -> if (isDarkMode) Color(0xFFFE9F06) else Color(0xFFFFA500)
        else -> if (isDarkMode) Color(0xFFFE9F06) else Color(0xFFFFA500)
    }
    
    val contentColor = if (symbol == "C" || symbol == "del" || symbol == "%") {
        Color.Black
    } else {
        Color.White
    }

    Button(
        onClick = { onClick(symbol) },
        modifier = modifier.size(72.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = CircleShape
    ) {
        Text(
            text = symbol,
            fontSize = 20.sp
        )
    }
}
