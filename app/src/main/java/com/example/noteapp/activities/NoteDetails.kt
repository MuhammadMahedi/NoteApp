package com.example.noteapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.noteapp.R
import com.example.noteapp.data.Note
import com.example.noteapp.databinding.ActivityNoteDetailsBinding

class NoteDetails : AppCompatActivity() {
    private var binding=ActivityNoteDetailsBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}