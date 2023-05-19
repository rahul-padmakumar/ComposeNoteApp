package com.example.composenoteapp.datas

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.composenoteapp.models.Note
import com.example.composenoteapp.utils.DateConverter

@Database(entities = [Note::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class NoteDatabase:RoomDatabase(){
    abstract fun noteDao(): NoteDatabaseDao
}