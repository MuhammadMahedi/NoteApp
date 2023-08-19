package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {
    // C create  R read  U update  D delete
    @Insert
    fun createContact(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAllContact():List<Contact>

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact)
}