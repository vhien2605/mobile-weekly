package com.hien.juicetracker.ui.component

// ui/component/JuiceEntryBottomSheet.kt
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hien.juicetracker.model.Juice

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JuiceEntryBottomSheet(
    onDismiss: () -> Unit,
    onSave: (Juice) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("Red") }
    var rating by remember { mutableStateOf(0) }

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 32.dp) // Padding for system navigation
        ) {
            Text("Type of juice", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Juice Name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Rating", modifier = Modifier.weight(1f))
                RatingBar(rating = rating, onRatingChanged = { rating = it })
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
                Button(
                    onClick = {
                        onSave(
                            Juice(
                                name = name,
                                description = description,
                                color = color,
                                rating = rating
                            )
                        )
                        onDismiss()
                    },
                    enabled = name.isNotBlank()
                ) {
                    Text("Save")
                }
            }
        }
    }
}