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
    var title:String,
    @ColumnInfo("Date")
    var date:String,
    @ColumnInfo("Description")
    var description:String

):Parcelable


