package com.hien.myapplication.ui.component.caculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InputSection(
    onInput: (String) -> Unit,
    isDarkMode: Boolean = false
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OperationInput("C", onInput, Modifier.weight(1f), isDarkMode)
            OperationInput("del", onInput, Modifier.weight(1f), isDarkMode)
            OperationInput("%", onInput, Modifier.weight(1f), isDarkMode)
            OperationInput("/", onInput, Modifier.weight(1f), isDarkMode)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NumberInput("7", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput("8", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput("9", onInput, Modifier.weight(1f), isDarkMode)
            OperationInput("x", onInput, Modifier.weight(1f), isDarkMode)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NumberInput("4", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput("5", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput("6", onInput, Modifier.weight(1f), isDarkMode)
            OperationInput("-", onInput, Modifier.weight(1f), isDarkMode)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NumberInput("1", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput("2", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput("3", onInput, Modifier.weight(1f), isDarkMode)
            OperationInput("+", onInput, Modifier.weight(1f), isDarkMode)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NumberInput("00", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput("0", onInput, Modifier.weight(1f), isDarkMode)
            NumberInput(".", onInput, Modifier.weight(1f), isDarkMode)
            OperationInput("=", onInput, Modifier.weight(1f), isDarkMode)
        }
    }
}
