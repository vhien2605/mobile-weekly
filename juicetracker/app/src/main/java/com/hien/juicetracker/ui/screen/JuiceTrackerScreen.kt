package com.hien.juicetracker.ui.screen

// ui/screen/JuiceTrackerScreen.kt
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.hien.juicetracker.ui.component.JuiceEntryBottomSheet
import com.hien.juicetracker.ui.component.JuiceListItem
import com.hien.juicetracker.viewmodel.JuiceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JuiceTrackerScreen(viewModel: JuiceViewModel) {
    val juices by viewModel.juices.collectAsState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Juice Tracker") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showBottomSheet = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add Juice")
            }
        }
    ) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(juices) { juice ->
                JuiceListItem(
                    juice = juice,
                    onDelete = { viewModel.deleteJuice(juice) }
                )
                HorizontalDivider()
            }
        }

        if (showBottomSheet) {
            JuiceEntryBottomSheet(
                onDismiss = { showBottomSheet = false },
                onSave = { newJuice -> viewModel.addJuice(newJuice) }
            )
        }
    }
}