package com.school.managementapplication.assignments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.school.managementapplication.Dataused
import com.school.managementapplication.announcements.AnnouncementOnClick
import com.school.managementapplication.databinding.FragmentAssignmentsBinding


class FragmentAssignments : Fragment() {
    lateinit var adapter : AssignmentsAdapter
    lateinit var binding: FragmentAssignmentsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAssignmentsBinding.inflate(layoutInflater)
        var datausedLists = mutableListOf<Dataused>(
            Dataused("Assignment 1","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 2","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 3","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 4","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 5","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 6","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 7","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 8","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 9","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 10","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 11","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 12","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),
            Dataused("Assignment 13","e in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"),

            )
        adapter = AssignmentsAdapter(datausedLists)

        adapter.onItemClick1 = {
            val intent = Intent(this@FragmentAssignments.requireContext(), AnnouncementOnClick::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("info", it.information)
            startActivity(intent)

        }
        binding.recyclerViewAnnouncements.adapter = adapter
        binding.recyclerViewAnnouncements.layoutManager = LinearLayoutManager(this@FragmentAssignments.requireContext())

        // Inflate the layout for this fragment
        return binding.root
    }
}