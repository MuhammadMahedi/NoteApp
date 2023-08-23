package com.example.noteapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.room.Room
import com.example.noteapp.R
import com.example.noteapp.data.Note
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.databinding.ActivityAddNoteBinding
import java.io.Serializable

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NoteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolBar=binding.toolbarAddNote
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolBar.title="Add Note"

        binding.toolbarAddNote.setNavigationOnClickListener {
            onBackPressed()
        }

        db= Room.databaseBuilder(applicationContext,
            NoteDatabase::class.java,
            "note_table")
            .allowMainThreadQueries()
            .build()


        binding.btnSave.setOnClickListener {
            val note= Note(
                0,
                binding.editTextTitle.text.toString(),
                binding.editTextDate.text.toString(),
                binding.editTextDescription.text.toString(),

                )
            db.getNoteDao().createNote(note)
            //var notes=db.getNoteDao().getAllNotes()
            val intent=Intent(this,MainActivity::class.java)
            //intent.putExtra("dataList", notes as Serializable)
            startActivity(intent)
            finish()
        }

    }

}