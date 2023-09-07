package com.example.noteapp.fragments

import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    private var noteModel:com.example.noteapp.data.Note?=null

    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            //param1 = it.getString(ARG_PARAM1)
            noteModel=it.getParcelable("myData")
            Log.i("ModelInfo",noteModel?.title.toString())



        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.titleDetail.text= noteModel?.title ?: "null"
        binding.descriptionDetail.text= noteModel?.description ?: "null"
        binding.dateDetail.text= noteModel?.date ?: "null"


    }


}