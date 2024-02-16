package com.suhel.notesapp.repository

import com.suhel.notesapp.database.NoteDatabase
import com.suhel.notesapp.model.Note

class NoteRepository(private val db:NoteDatabase) {

    suspend fun insertNote(note: Note)=db.getNoteDao().insertNote(note)

    suspend fun updatetNote(note: Note)=db.getNoteDao().updateNote(note)

    suspend fun deletetNote(note: Note)=db.getNoteDao().deleteNote(note)

    fun getAllNotes()= db.getNoteDao().getAllNotes()
    fun searchNote(query:String?)=db.getNoteDao().searchNote(query)

}