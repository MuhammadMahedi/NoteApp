package com.example.noteapp.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.noteapp.R
import com.example.noteapp.data.Note
import com.example.noteapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolBar=binding.toolbarAddNote
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbarAddNote.setNavigationOnClickListener {
            onBackPressed()
        }

        //var noteModel = intent.getSerializableExtra("NoteDetails")
        val noteModel=intent.getParcelableExtra("FullData",Note::class.java)

        with(binding) {
            this.titleDetail.text = noteModel!!.title
            this.dateDetail.text = noteModel.date
            this.descriptionDetail.text = noteModel.description
        }
    }
}