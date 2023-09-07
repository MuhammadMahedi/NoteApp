package com.example.noteapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Note
import com.example.noteapp.repo.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(var repos:NoteRepo): ViewModel() {



    private var _allNotes:MutableLiveData<List<Note>> = MutableLiveData<List<Note>>()

    val allNotes:LiveData<List<Note>> get() = _allNotes



  fun addData(note:Note){
        viewModelScope.launch {
            repos.addNote(note)
        }


    }

    fun getAllNotes(){
        _allNotes.postValue(repos.getAllNotes())
    }


}