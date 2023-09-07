package com.example.noteapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.adapters.NoteAdapter
import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.io.Serializable
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)  /*

        binding.fabAddNote.setOnClickListener{
            val intent=Intent(this,AddNoteActivity::class.java)//
            startActivity(intent)
            finish()
        }
        //var noteList=intent.getSerializableExtra("dataList") as? List<Note>
        var noteList=getAllNotes()

        val noteAdapter=NoteAdapter(this,noteList)
        binding.rvNote.adapter=noteAdapter

        noteAdapter.setOnClickListener(object : NoteAdapter.OnClickListener {
            override fun onClick(position: Int, model: Note) {
              val intent = Intent(this@MainActivity,DetailsActivity::class.java)
                //intent.putExtra("NoteDetails",model as Serializable)
               intent.putExtra("FullData",model)
                startActivity(intent)
            }
//


        })




    }
    private fun getAllNotes():List<Note>{

        val db= Room.databaseBuilder(applicationContext,
            NoteDatabase::class.java,
            "note_table")
            .allowMainThreadQueries()
            .build()
        var notes=db.getNoteDao().getAllNotes()

        return notes  */

    }
}