package com.school.managementapplication.syllabus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.managementapplication.databinding.FragmentSyllabusBinding


class FragmentSyllabus : Fragment() {

    lateinit var  binding : FragmentSyllabusBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSyllabusBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
}