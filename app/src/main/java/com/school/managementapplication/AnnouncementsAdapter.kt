package com.school.managementapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.school.managementapplication.databinding.RowAnnouncementsBinding

class AnnouncementsAdapter (val announcements: MutableList<Dataused>):RecyclerView.Adapter<AnnouncementsAdapter.AnnouncementsHolder>(){
    var onItemClick1  : ((Dataused)->Unit)? = null
    //delete
    var onDeleteButtonClick : ((Dataused, Int)-> Unit)? = null
    inner class AnnouncementsHolder(val binding: RowAnnouncementsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowAnnouncementsBinding.inflate(layoutInflater,parent,false)
        return AnnouncementsHolder(binding)
    }

    override fun onBindViewHolder(holder: AnnouncementsHolder, position: Int) {
        holder.binding.apply {
            tvAnnouncementsTitle.text = announcements[position].title
            tvAnnouncementsDesc.text = announcements[position].information

            btndelete.setOnClickListener() {
                onDeleteButtonClick?.invoke(announcements[position],position)
            }
        }
        holder.itemView.setOnClickListener {
            onItemClick1?.invoke(announcements[position])
        }

    }

    override fun getItemCount(): Int {
        return announcements.size
    }

}
