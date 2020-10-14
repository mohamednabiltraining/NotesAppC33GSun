package com.route.notesappc33gsun.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.notesappc33gsun.R
import com.route.notesappc33gsun.database.entity.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(var notes: List<Note>?) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    fun changeData(notes: List<Note>) {
        this.notes = notes;
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes?.get(position)
        holder.title.setText(note?.title)
        holder.desc.setText(note?.description)
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val title = itemView.title;
        val desc = itemView.description
    }
}