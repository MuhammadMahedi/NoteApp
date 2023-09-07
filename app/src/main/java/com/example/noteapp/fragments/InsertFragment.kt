package com.example.noteapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapp.data.Note
import com.example.noteapp.databinding.FragmentInsertBinding
import com.example.noteapp.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsertFragment : BaseFragment<FragmentInsertBinding>(FragmentInsertBinding::inflate) {
    private val viewModel:HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.btnSave.setOnClickListener {

            val note= Note(
                0,
                binding.editTextTitle.text.toString(),
                binding.editTextDate.text.toString(),
                binding.editTextDescription.text.toString(),

                )

            viewModel.addData(note)

//            var db= Room.databaseBuilder(requireContext(),
//                NoteDatabase::class.java,
//                "note_table")
//                .allowMainThreadQueries()
//                .build()
//
//               db.getNoteDao().createNote(note)

           //findNavController().navigate(R.id.action_insertFragment_to_homeFragment)

            findNavController().popBackStack()

        }
    }





}