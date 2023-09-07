package com.example.noteapp.repo

import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteDao
import javax.inject.Inject

class NoteRepo @Inject constructor(private val dao:NoteDao) {

    fun getAllNotes():List<Note>{
        return dao.getAllNotes()
    }

    suspend fun addNote(note: Note){
        dao.createNote(note)
    }
}