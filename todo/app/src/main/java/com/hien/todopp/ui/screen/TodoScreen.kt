package com.hien.todopp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hien.todopp.ui.component.TodoItem

@Composable
fun TodoScreen() {
    val todoList = listOf(
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
        "Label text",
    )

    Scaffold(
        topBar = {
            Text(
                text = "Todo app",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(todoList) { item ->
                TodoItem(
                    title = item,
                    onClick = {}
                )
            }
        }
    }
}