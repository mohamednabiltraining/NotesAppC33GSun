package com.route.notesappc33gsun.database.dao

import androidx.room.*
import com.route.notesappc33gsun.database.entity.Note

@Dao
interface NotesDao {
    // contains all operation needed in notes table

    @Insert
    fun addNote(note: Note);

    @Delete
    fun deleteNote(note: Note)

    @Query("delete from notes where id =:id")
    fun deleteNoteById(id: Int)

    @Update
    fun updateNote(note: Note)

    @Query("select * from notes")
    fun getAllNotes(): List<Note>

    @Insert
    fun insertAllNotes(data: List<Note>)

    @Query("select * from notes where title like :q or description like:q")
    fun searchNotes(q: String): List<Note>// android
}