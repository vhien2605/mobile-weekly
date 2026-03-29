package com.hien.mywaterok.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hien.mywaterok.model.Plant
import com.hien.mywaterok.ui.component.PlantCard
import com.hien.mywaterok.viewmodel.WaterViewModel
import java.util.concurrent.TimeUnit

@Composable
fun PlantListScreen(viewModel: WaterViewModel) {
    var selectedPlant by remember { mutableStateOf<Plant?>(null) }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(viewModel.plants) { plant ->
            PlantCard(
                plant = plant,
                onClick = { selectedPlant = plant }
            )
        }
    }

    // Hiển thị Dialog khi có cây được chọn
    selectedPlant?.let { plant ->
        AlertDialog(
            onDismissRequest = { selectedPlant = null },
            title = { Text(text = "Remind me to water \n${plant.name} in...") },
            text = {
                Column {
                    ReminderButton("5 seconds") {
                        viewModel.scheduleReminder(plant, 5, TimeUnit.SECONDS)
                        selectedPlant = null
                    }
                    ReminderButton("1 day") {
                        viewModel.scheduleReminder(plant, 1, TimeUnit.DAYS)
                        selectedPlant = null
                    }
                    ReminderButton("1 week") {
                        viewModel.scheduleReminder(plant, 7, TimeUnit.DAYS)
                        selectedPlant = null
                    }
                    ReminderButton("1 month") {
                        viewModel.scheduleReminder(plant, 30, TimeUnit.DAYS)
                        selectedPlant = null
                    }
                }
            },
            confirmButton = {}
        )
    }
}

@Composable
fun ReminderButton(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.onSurface)
    }
}