package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.time.delay

@Dao
interface NoteDao {
    // C create  R read  U update  D delete
    @Insert
   suspend fun createNote(note:Note)

    @Query("SELECT * FROM Note")
    fun getAllNotes():List<Note>

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}