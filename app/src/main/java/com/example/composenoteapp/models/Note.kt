package com.example.composenoteapp.models

import java.util.*

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val desc: String,
    val entryTimeStamp: Long = System.currentTimeMillis()
)
