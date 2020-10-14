package com.route.notesappc33gsun.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.notesappc33gsun.database.dao.NotesDao
import com.route.notesappc33gsun.database.entity.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun notesDao(): NotesDao


    companion object {
        private val DATABASE_NAME = "notes-database";
        fun getInstance(context: Context): NotesDatabase {
            val notesDatabase = Room.databaseBuilder(
                context, NotesDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries()
                .fallbackToDestructiveMigration()// clear data if version is upgrade
                .build()
            return notesDatabase;
        }
    }


}