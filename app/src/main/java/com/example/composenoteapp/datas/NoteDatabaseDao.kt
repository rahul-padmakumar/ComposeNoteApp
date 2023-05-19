package com.example.composenoteapp.datas

import androidx.room.*
import com.example.composenoteapp.models.Note

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from note_tbl")
    fun getNotes(): List<Note>

    @Query("SELECT * from note_tbl where id = :id")
    fun getNote(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Query("DELETE from note_tbl")
    fun delete()

    @Delete
    fun delete(note: Note)
}