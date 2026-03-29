package com.hien.juicetracker.model


data class Juice(
    val id: Int = 0,
    val name: String,
    val description: String,
    val color: String,
    val rating: Int
)