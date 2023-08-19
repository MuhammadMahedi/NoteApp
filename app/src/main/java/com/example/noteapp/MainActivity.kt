package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.room.Room
import com.example.noteapp.data.Contact
import com.example.noteapp.data.ContactDatabase
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var db:ContactDatabase
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= Room.databaseBuilder(applicationContext,
            ContactDatabase::class.java,
            "contact_table")
            .allowMainThreadQueries()
            .build()

        binding.btnSave.setOnClickListener {
            val contact=Contact(
                0,
                binding.editTextName.text.toString(),
                binding.editTextEmail.text.toString(),
                binding.editTextPhone.text.toString(),

            )
            db.getContactDao().createContact(contact)
        }

        binding.getAll.setOnClickListener {

            binding.text.text=" "
            var contacts=db.getContactDao().getAllContact()

            contacts.forEach {
                binding.text.text=("${binding.text.text} \n\n ${it.id}\t\t${it.name}\t\t${it.email}\t\t${it.phone}")
            }
        }
    }
}