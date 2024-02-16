package com.suhel.notesapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.suhel.notesapp.database.NoteDatabase
import com.suhel.notesapp.model.Note
import com.suhel.notesapp.repository.NoteRepository
import com.suhel.notesapp.viewModel.NoteViewModel
import com.suhel.notesapp.viewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository=NoteRepository(NoteDatabase(this))
        val vieModelProviderFactory=NoteViewModelFactory(application,noteRepository)
        noteViewModel=ViewModelProvider(this,vieModelProviderFactory)[NoteViewModel::class.java]

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Exit")
            setIcon(android.R.drawable.ic_dialog_alert)
            setMessage("Do you want to Exit this app")
            setPositiveButton("Exit"){_,_ ->
                finish()
            }
            setNegativeButton("Cancel", null)
        }.create().show()
    }
}