package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.NoteDao
import com.example.noteapp.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBProvider {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context):NoteDatabase{

        return NoteDatabase.getInstance(context)
//        Room.databaseBuilder(context,
//            NoteDatabase::class.java,
//            "note_table")
//            .allowMainThreadQueries()
//            .build()
    }

    @Provides
    @Singleton
    fun provideDao(db:NoteDatabase):NoteDao{

        return db.getNoteDao()
    }
}