package com.school.managementapplication.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.school.managementapplication.Dataused
import com.school.managementapplication.databinding.RowNotesBinding

class NotesAdapter (val notes : MutableList<Dataused>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){
    // to pass a setonclicklistener to the Home page.
    //lambda sample
    var onItemClick : ((Dataused)-> Unit)? = null
    //dialog edit
    var onUpdateButtonClick : ((Dataused,Int)-> Unit)? = null
    //delete
    var onDeleteButtonClick: ((Dataused,Int)-> Unit)? = null
    inner class NotesViewHolder(val binding:RowNotesBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowNotesBinding.inflate(layoutInflater,parent,false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.binding.apply{
            tvNotesTitle.text = notes[position].title
            tvNotesDesc.text = notes[position].information

            imgBtnDeleteNotes.setOnClickListener(){
                onDeleteButtonClick?.invoke(notes[position],position)
            }
            imgbtnEditNotes.setOnClickListener(){
                onUpdateButtonClick?.invoke(notes[position],position)
            }
        }
        // to make the viewcard functional
        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(notes[position])
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }


}