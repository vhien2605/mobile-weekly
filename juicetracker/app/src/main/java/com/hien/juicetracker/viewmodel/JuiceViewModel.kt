package com.hien.juicetracker.viewmodel

import androidx.lifecycle.ViewModel
import com.hien.juicetracker.model.Juice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class JuiceViewModel : ViewModel() {
    private val _juices = MutableStateFlow<List<Juice>>(emptyList())
    val juices: StateFlow<List<Juice>> = _juices.asStateFlow()

    fun addJuice(juice: Juice) {
        val newId = (_juices.value.maxOfOrNull { it.id } ?: 0) + 1
        val newJuice = juice.copy(id = newId)
        _juices.value = _juices.value + newJuice
    }

    fun deleteJuice(juice: Juice) {
        _juices.value = _juices.value - juice
    }
}