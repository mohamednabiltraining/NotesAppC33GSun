package com.route.notesappc33gsun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.notesappc33gsun.adapter.NotesAdapter
import com.route.notesappc33gsun.database.NotesDatabase
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    val adapter = NotesAdapter(null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView.adapter = adapter
        add_note
            .setOnClickListener {
                startActivity(
                    Intent(
                        this@HomeActivity,
                        AddNote::class.java
                    )
                )
            }
    }

    // android runtime permission
    override fun onStart() {
        super.onStart()
        val list = NotesDatabase.getInstance(applicationContext)
            .notesDao()
            .getAllNotes()
        adapter.changeData(list)
    }

}