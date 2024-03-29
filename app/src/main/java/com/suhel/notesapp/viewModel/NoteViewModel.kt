package com.suhel.notesapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.suhel.notesapp.model.Note
import com.suhel.notesapp.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app :Application,private val noteRepository: NoteRepository):AndroidViewModel(app) {

    fun addNote(note: Note) {
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updatetNote(note)
        }
    }

    fun deleteNote(note: Note){
        viewModelScope.launch {
            noteRepository.deletetNote(note)
        }
    }

    fun getAllNotes()=noteRepository.getAllNotes()

    fun searchNote(query:String?)=noteRepository.searchNote(query)
}