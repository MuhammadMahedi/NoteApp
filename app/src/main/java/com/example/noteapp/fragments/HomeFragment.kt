package com.example.noteapp.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.noteapp.R
import com.example.noteapp.adapters.NoteAdapter
import com.example.noteapp.data.Note
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    lateinit var navController: NavController
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var noteAdapter: NoteAdapter //? = null
    lateinit var data: List<Note>




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllNotes()
        setTheScreen()
        /*viewModel.allNotes.observe(viewLifecycleOwner) {
            data = it
            noteAdapter = NoteAdapter(requireContext(), data)
            binding.rvNote.adapter = noteAdapter

            showDetails(noteAdapter)


        }*/


        navController = Navigation.findNavController(view)
        binding.fabAddNote.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_insertFragment)
        }

}
    private fun showDetailsOrDelete(adapter: NoteAdapter){

        adapter.setOnClickListener(object : NoteAdapter.OnClickListener {

            override fun onClick(position: Int, model: Note) {
                val bundle = Bundle()
                bundle.putParcelable("myData", model)
                navController.navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
            }

            override fun onDeleteClick(model: Note) {
                //Toast.makeText(requireContext(), "ddddd", Toast.LENGTH_SHORT).show()
                AlertDialog.Builder(requireContext())
                    .setMessage("Are You Sure you Want to delete this note?")
                    .setPositiveButton("Yes"){ _, _ ->
                        viewModel.deleteData(model)
                        //viewModel.getAllNotes()
                        //      setTheScreen()
                        Toast.makeText(requireContext(), "deleted Successfully", Toast.LENGTH_SHORT).show()

                    }.setNegativeButton("No"){ dialog, _ ->
                        dialog.dismiss()
                    }.show()

            }

        })
    }

    fun setTheScreen(){
        viewModel.allNotes.observe(viewLifecycleOwner) {
            data = it
            noteAdapter = NoteAdapter(requireContext(), data)
            binding.rvNote.adapter = noteAdapter
            showDetailsOrDelete(noteAdapter)


        }
    }



}