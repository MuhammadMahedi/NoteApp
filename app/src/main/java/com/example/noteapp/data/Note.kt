package com.example.noteapp.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @ColumnInfo("Title")
    val title:String,
    @ColumnInfo("Date")
    val date:String,
    @ColumnInfo("Description")
    val description:String

):Parcelable


