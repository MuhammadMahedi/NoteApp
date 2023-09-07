package com.example.noteapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun getNoteDao():NoteDao

    companion object{
        private var db:NoteDatabase?=null
        fun getInstance(context: Context): NoteDatabase{
            if(db==null){
                db= Room.databaseBuilder(context,
                    NoteDatabase::class.java,
                    "note_table")
                    .allowMainThreadQueries()
                    .build()

                return db as NoteDatabase
            }else{
                return db as NoteDatabase
            }
        }
    }
}