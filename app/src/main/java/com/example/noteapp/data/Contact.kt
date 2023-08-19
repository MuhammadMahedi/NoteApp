package com.example.noteapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @ColumnInfo("Name")
    val name:String,
    @ColumnInfo("Email")
    val email:String,
    @ColumnInfo("Phone")
    val phone:String

)


