package com.school.managementapplication.assignments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.school.managementapplication.Dataused
import com.school.managementapplication.databinding.RowAssignmentsBinding

class AssignmentsAdapter (val assignments: MutableList<Dataused>):RecyclerView.Adapter<AssignmentsAdapter.AssignmentsViewHolder>(){
    var onItemClick1  : ((Dataused)->Unit)? = null
    var onDeleteButtonClick : ((Dataused, Int)-> Unit)? = null
    inner class AssignmentsViewHolder(val binding: RowAssignmentsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowAssignmentsBinding.inflate(layoutInflater,parent,false)
        return AssignmentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssignmentsViewHolder, position: Int) {
        holder.binding.apply {
            tvAssignmentsDesc.text = assignments[position].information
            tvAssignmentsTitle.text = assignments[position].title

            btnMark.setOnClickListener(){
                onDeleteButtonClick?.invoke(assignments[position],position)
            }
        }
        holder.itemView.setOnClickListener {
            onItemClick1?.invoke(assignments[position])
        }
    }

    override fun getItemCount(): Int {
        return assignments.size
    }

}
