package com.example.composenoteapp.datas

import com.example.composenoteapp.models.Note

class NoteDataSource{
    fun loadNotes(): List<Note> = listOf(
        Note(title = "Android compose", desc = "Hello declarative UI"),
        Note(title = "Android compose1", desc = "Hello declarative UI"),
        Note(title = "Android compose2", desc = "Hello declarative UI"),
        Note(title = "Android compose3", desc = "Hello declarative UI"),
        Note(title = "Android compose4", desc = "Hello declarative UI"),
        Note(title = "Android compose5", desc = "Hello declarative UI"),
        Note(title = "Android compose6", desc = "Hello declarative UI"),
        Note(title = "Android compose7", desc = "Hello declarative UI"),
        Note(title = "Android compose8", desc = "Hello declarative UI")
    )
}