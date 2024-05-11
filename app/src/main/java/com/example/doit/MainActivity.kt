package com.example.doit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doit.databinding.ActivityAddnoteBinding
import com.example.doit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private  lateinit var db : NotesDatabaseHelper
    private lateinit var  notesAdapter: NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes(),this)

        binding.NotesRecycleView.layoutManager = LinearLayoutManager(this)
        binding.NotesRecycleView.adapter = notesAdapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this,Addnote::class.java)
            startActivity(intent)
        }
        }

    override fun onResume() {
        super.onResume()
        notesAdapter.refreshdata(db.getAllNotes())
    }


    }
