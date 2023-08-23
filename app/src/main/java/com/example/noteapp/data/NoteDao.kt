package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    // C create  R read  U update  D delete
    @Insert
    fun createNote(note:Note)

    @Query("SELECT * FROM Note")
    fun getAllNotes():List<Note>

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}