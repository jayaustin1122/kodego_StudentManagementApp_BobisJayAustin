package com.school.managementapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.managementapplication.databinding.FragmentAnnouncementBinding
import com.school.managementapplication.databinding.FragmentAssignmentsBinding


class FragmentAssignments : Fragment() {
    lateinit var binding: FragmentAssignmentsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAssignmentsBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
}