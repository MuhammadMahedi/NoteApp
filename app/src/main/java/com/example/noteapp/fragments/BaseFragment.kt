package com.example.noteapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import androidx.viewbinding.ViewBinding
import com.example.noteapp.data.NoteDatabase
import java.util.zip.Inflater

abstract class BaseFragment< VB: ViewBinding>(
    private var bindingInflater: ( inflater:LayoutInflater)->VB
):Fragment() {

    private var _binding:VB? = null
    val binding:VB
        get() = _binding as VB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding=bindingInflater.invoke(inflater)



        return binding.root
    }
}