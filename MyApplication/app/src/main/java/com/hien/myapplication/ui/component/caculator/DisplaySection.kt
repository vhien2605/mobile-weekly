package com.hien.myapplication.ui.component.caculator

import androidx.compose.runtime.Composable


@Composable
fun DisplaySection(
    expression: String,
    result: String,
    isDarkMode: Boolean = false
) {
    ResultCaculator(
        expression = expression,
        result = result,
        isDarkMode = isDarkMode
    )
}
