package com.example.composenoteapp.datas

import androidx.room.*
import com.example.composenoteapp.models.Note

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from note_tbl")
    fun getNotes(): List<Note>

    @Query("SELECT * from note_tbl where id = :id")
    suspend fun getNote(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from note_tbl")
    suspend fun delete()

    @Delete
    suspend fun delete(note: Note)
}