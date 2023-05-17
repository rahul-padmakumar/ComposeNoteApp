package com.example.composenoteapp.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.composenoteapp.datas.NoteDataSource
import com.example.composenoteapp.models.Note

class NoteViewModel: ViewModel() {
    private val notes = mutableStateListOf<Note>()

    init {
        notes.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note){
        notes.add(note)
    }

    fun removeNote(note: Note){
        notes.remove(note)
    }

    fun getAllNotes(): List<Note> = notes
}
