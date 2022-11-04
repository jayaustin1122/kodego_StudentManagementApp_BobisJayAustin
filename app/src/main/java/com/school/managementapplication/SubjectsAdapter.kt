package com.school.managementapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.school.managementapplication.databinding.ActivityStudentHomePageBinding
import com.school.managementapplication.databinding.RowSubjectsBinding

class SubjectsAdapter(val subjects : MutableList<Subjects>):RecyclerView.Adapter<SubjectsAdapter.SubjectViewHolder>() {
    var onItemClick : ((Subjects)-> Unit)? = null
    inner class SubjectViewHolder(val binding: RowSubjectsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowSubjectsBinding.inflate(layoutInflater,parent,false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.binding.apply {
            textSubTitle.text = subjects[position].subTitle
            textSubDesc.text = subjects[position].subDescription
            textSubSched.text = subjects[position].subSchedule
            imgsubs.setImageResource(subjects[position].subBg)
            tvtime.text = subjects[position].time
        }
        // to make the viewcard functional
        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(subjects[position])
        }
    }

    override fun getItemCount(): Int {
        return subjects.size
    }
}