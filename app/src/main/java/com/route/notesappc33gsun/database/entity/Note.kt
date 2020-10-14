package com.route.notesappc33gsun.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo
    val title: String? = null,
    @ColumnInfo
    val description: String? = null,
    @ColumnInfo
    val date: String? = null
);