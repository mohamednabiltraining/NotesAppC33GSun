package com.route.notesappc33gsun

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.notesappc33gsun.base.BaseActivity
import com.route.notesappc33gsun.database.NotesDatabase
import com.route.notesappc33gsun.database.entity.Note
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNote : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        add.setOnClickListener {

            val titleString = note_title.text.toString()
            val desc = description.text.toString()
            val dateString = date.text.toString()

            NotesDatabase
                .getInstance(applicationContext)
                .notesDao()
                .addNote(
                    Note(
                        title = titleString,
                        description = desc,
                        date = dateString
                    )
                )

            showMessage(message = "note added successfully"
                , posActionName = "ok",
                posAction = DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                    finish()

                }, cancelable = false
            )

        }
    }
}