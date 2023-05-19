package com.example.composenoteapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenoteapp.models.Note
import com.example.composenoteapp.repos.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository): ViewModel() {

    private val notes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val noteList = notes.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO){
            noteRepository.getAllNotes().distinctUntilChanged()
                .collect{
                    notes.tryEmit(it)
                }
        }
    }
    fun addNote(note: Note) = viewModelScope.launch {
        noteRepository.addNote(note = note)
    }

    fun removeNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }

    fun updateNote(note: Note) = viewModelScope.launch {
        noteRepository.updateNote(note = note)
    }
}
