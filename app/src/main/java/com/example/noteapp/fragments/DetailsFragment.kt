package com.example .noteapp.fragments

import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentDetailsBinding
import com.example.noteapp.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    private var noteModel:com.example.noteapp.data.Note?=null
    private val viewModel: HomeViewModel by viewModels()


    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            noteModel=it.getParcelable("myData")
            Log.i("ModelInfo",noteModel?.title.toString())



        }
    }

    /*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.fragment_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_back -> {
                requireActivity().onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

     */


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //This codes are for A toolbar with back button.
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.detailsToolbar)
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setTitle("Update details")
        binding.detailsToolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }


        binding.titleDetail.setText(noteModel?.title ?: "null")
        binding.descriptionDetail.setText(noteModel?.description ?: "null")
        binding.dateDetail.setText(noteModel?.date ?: "null")

    //= (noteModel?.title ?: "null") as Editable?
        //binding.descriptionDetail.text= (noteModel?.description ?: "null") as Editable?
       // binding.dateDetail.text= (noteModel?.date ?: "null") as Editable?

        binding.updateButton.setOnClickListener {
            noteModel?.title = binding.titleDetail.text.toString()
            noteModel?.description=binding.descriptionDetail.text.toString()
            noteModel?.date = binding.dateDetail.text.toString()


            if (noteModel!=null)
                viewModel.updateData(noteModel!!)

            findNavController().popBackStack()
        }


    }


}