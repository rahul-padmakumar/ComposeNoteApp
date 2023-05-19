package com.example.composenoteapp.datas

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composenoteapp.models.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase(){
    abstract fun noteDao(): NoteDatabaseDao
}